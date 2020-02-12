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

    @Override
    public int remit(Account in, Account out) throws IOException {
        //先获取mybatis全局配置,转换字节流，以便接下来交给SqlSessionFactoryBuilder使用
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获得sqlSessionFactory,建造者模式
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //根据传入的转出账户和密码查询转出账户信息
        Account selectByOut = sqlSession.selectOne("com.geng.mapper.selectByAccNoAndPW", out);
        //如果转入账户不为空
        if (selectByOut != null) {
            //如果需要转出金额-余额<=0，那么允许进行下一步
            if ((out.getBalance().compareTo(selectByOut.getBalance())) <= 0) {
                //根据传入的转入账户和姓名查询转入账户信息
                Account selectByIn = sqlSession.selectOne("com.geng.mapper.selectByAccNoAndName", in);
                //判断转入账户信息是否存在
                if (selectByIn != null) {

                }else {

                }
            } else {
                //否则失败
                return statusForFirm.ERROR;
            }

        } else {
            return statusForFirm.BALANCE_IS_NOT_ENOUGH;
        }
        return 0;
    }
}
