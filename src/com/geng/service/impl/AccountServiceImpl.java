package com.geng.service.impl;

import com.geng.pojo.Account;
import com.geng.service.AccountService;
import com.geng.utils.StatusForFirm;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

/**
 * 用款账户业务逻辑实现
 */
public class AccountServiceImpl implements AccountService {
    private StatusForFirm statusForFirm;

    /**
     * 转账业务逻辑实现
     *
     * @param in
     * @param out
     * @return
     * @throws IOException
     */
    @Override
    public int remit(Account in, Account out) throws IOException {
        //先获取mybatis全局配置,转换字节流，以便接下来交给SqlSessionFactoryBuilder使用
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获得sqlSessionFactory,建造者模式
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //根据传入的转出账户和密码查询转出账户信息
        Account selectByOut = sqlSession.selectOne("com.geng.mapper.AccountMapper.selectByAccNoAndPW", out);
        //如果转入账户不为空
        if (selectByOut != null) {
            //如果需要转出金额小于或等于余额，那么允许进行下一步
            if ((out.getBalance().compareTo(selectByOut.getBalance())) <= 0) {
                //根据传入的转入账户和姓名查询转入账户信息
                Account selectByIn = sqlSession.selectOne("com.geng.mapper.AccountMapper.selectByAccNoAndName", in);
                //判断转入账户信息是否存在
                if (selectByIn != null) {
                    //更新转出账户的余额
                    out.setBalance((out.getBalance().negate()));
                    int index = sqlSession.update("com.geng.mapper.AccountMapper.updateBalanceByAccNo", out);
                    //更新转入账户的余额
                    index += sqlSession.update("com.geng.mapper.AccountMapper.updateBalanceByAccNo", in);
                    if (index == 2) {
                        sqlSession.commit();
                        sqlSession.close();
                        //返回交易执行成功
                        return statusForFirm.SUCCESS;
                    } else {
                        //否则返回错误,事务回滚
                        sqlSession.rollback();
                        return statusForFirm.ERROR;
                    }
                } else {
                    //否则返回账户姓名错误
                    return statusForFirm.ACCOUNT_NAME_NOT_MATCH;
                }
            } else {
                //否则返回余额不足
                return statusForFirm.BALANCE_IS_NOT_ENOUGH;
            }
        } else {
            //返回账户及密码错误
            return statusForFirm.ACCOUNT_AND_PASSWORD_NOT_MATCH;
        }

    }
}
