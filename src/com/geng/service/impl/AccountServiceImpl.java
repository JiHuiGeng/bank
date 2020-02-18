package com.geng.service.impl;

import com.geng.mapper.AccountMapper;
import com.geng.mapper.LogMapper;
import com.geng.pojo.Account;
import com.geng.pojo.Log;
import com.geng.service.AccountService;
import com.geng.utils.StatusForFirm;
import org.apache.ibatis.io.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 用款账户业务逻辑实现
 */
public class AccountServiceImpl implements AccountService {
    private StatusForFirm statusForFirm;
    private AccountMapper accountMapper;
    private LogMapper logMapper;

    public AccountMapper getAccountMapper() {
        return accountMapper;
    }

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public LogMapper getLogMapper() {
        return logMapper;
    }

    public void setLogMapper(LogMapper logMapper) {
        this.logMapper = logMapper;
    }

    /**
     * 转账业务逻辑实现
     *
     * @param in
     * @param out
     * @return
     * @throws IOException
     */
    @Override
    public String remit(Account in, Account out) throws IOException {
        Account selectByOut = accountMapper.selectByAccNoAndPW(out);
        if (selectByOut != null) {
            //如果转出金额<=余额，那么允许进行下一步
            if (out.getBalance().compareTo(selectByOut.getBalance()) <= 0) {
                //根据传入的转入账户和姓名查询转入账户信息
                Account selectIn = accountMapper.selectByAccNoAndName(in);
                //转入账户信息存在
                if (selectIn != null) {
                    //更新转入账户的余额
                    in.setBalance(out.getBalance());
                    //更新转出账户余额(为负)
                    out.setBalance(out.getBalance().negate());
                    //更新数据库
                    int index = accountMapper.updateBalanceByAccNo(out);
                    index += accountMapper.updateBalanceByAccNo(in);
                    if (index == 2) {
                        Log log = new Log();
                        log.setInAccNo(in.getAccNo());
                        log.setOutAccNo(out.getAccNo());
                        log.setMoney(in.getBalance());
                        //记录日志
                        int i = logMapper.insertLog(log);
                        //成功
                        return statusForFirm.SUCCESS;
                    } else {
                        //失败
                        return statusForFirm.ERROR;
                    }
                } else {
                    //账户姓名错误
                    return statusForFirm.ACCOUNT_NAME_NOT_MATCH;
                }
            } else {
                //余额不足
                return statusForFirm.BALANCE_IS_NOT_ENOUGH;
            }
        } else {
            //账户及密码错误
            return statusForFirm.ACCOUNT_AND_PASSWORD_NOT_MATCH;
        }
        //        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
//        //获得sqlSessionFactory,建造者模式
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        //获得sqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        //根据传入的转出账户和密码查询转出账户信息
//        Account selectByOut = sqlSession.selectOne("com.geng.mapper.AccountMapper.selectByAccNoAndPW", out);
//        //如果转入账户不为空
//        if (selectByOut != null) {
//            //如果需要转出金额小于或等于余额，那么允许进行下一步
//            if ((out.getBalance().compareTo(selectByOut.getBalance())) <= 0) {
//                //根据传入的转入账户和姓名查询转入账户信息
//                Account selectByIn = sqlSession.selectOne("com.geng.mapper.AccountMapper.selectByAccNoAndName", in);
//                //判断转入账户信息是否存在
//                if (selectByIn != null) {
//                    in.setBalance(out.getBalance());
//                    //更新转出账户的余额
//                    out.setBalance((out.getBalance().negate()));
//
//                    int index = sqlSession.update("com.geng.mapper.AccountMapper.updateBalanceByAccNo", out);
//                    //更新转入账户的余额
//                    index += sqlSession.update("com.geng.mapper.AccountMapper.updateBalanceByAccNo", in);
//                    if (index == 2) {
//                        //首先记录成功日志
//                        Log log = new Log();
//                        //转入账户
//                        log.setInAccNo(in.getAccNo());
//                        //转出账户
//                        log.setOutAccNo(out.getAccNo());
//                        //金额
//                        log.setMoney(in.getBalance());
//                        //记录日志
//                        sqlSession.insert("com.geng.mapper.LogMapper.insertLog", log);
//                        Logger logger = Logger.getLogger(AccountServiceImpl.class);
//                        //日志打印
//                        logger.info(log.getOutAccNo() + "给" + log.getInAccNo() + "转了:" + log.getMoney() + ",时间:" + Calendar.getInstance());
//                        sqlSession.commit();
//                        sqlSession.close();
//                        //返回交易执行成功
//                        return statusForFirm.SUCCESS;
//                    } else {
//                        //否则返回错误,事务回滚
//                        sqlSession.rollback();
//                        return statusForFirm.ERROR;
//                    }
//                } else {
//                    //否则返回账户姓名错误
//                    return statusForFirm.ACCOUNT_NAME_NOT_MATCH;
//                }
//            } else {
//                //否则返回余额不足
//                return statusForFirm.BALANCE_IS_NOT_ENOUGH;
//            }
//        } else {
//            //返回账户及密码错误
//            return statusForFirm.ACCOUNT_AND_PASSWORD_NOT_MATCH;
//        }
    }

    /**
     * 查询全部
     *
     * @return
     */
    @Override
    public List<Account> selectAll() {
        return accountMapper.selectAll();
    }

    /**
     * login
     *
     * @param account
     * @return
     */
    @Override
    public Account login(Account account) {
        return accountMapper.selectByAccNoAndPW(account);
    }

    /**
     * createAccount
     *
     * @param account
     * @return
     */
    @Override
    public String createAccount(Account account) {
        String returnCode = null;
        if (account.getAccNo() == null && account.getAccNo().equals("")) {
            return statusForFirm.ACCOUNT_IS_EMPTY;
        }
        int index = accountMapper.insertAccount(account);
        if (index > 0) {
            returnCode = statusForFirm.SUCCESS;
        } else {
            returnCode = statusForFirm.ERROR;

        }
        return returnCode;
    }
}
