package com.geng.service;

import com.geng.pojo.Account;

import java.io.IOException;

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
    public int remit(Account in, Account out) throws IOException;
}
