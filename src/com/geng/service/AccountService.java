package com.geng.service;

import com.geng.pojo.Account;

import java.io.IOException;
import java.util.List;

/**
 * 用款账户业务逻辑接口
 */
public interface AccountService {

    /**
     * 转账
     *
     * @param in
     * @param out
     * @return
     */
    int remit(Account in, Account out) throws IOException;

    /**
     * selectAll
     *
     * @return
     */
    List<Account> selectAll();
}
