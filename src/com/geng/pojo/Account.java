package com.geng.pojo;

import java.math.BigDecimal;

/**
 *
 */
public class Account {
    /**
     * 账户编号
     */
    private int id;
    /**
     * 账户
     */
    private String accNo;
    /**
     * 密码
     */
    private int password;
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 姓名
     */
    private String name;

    public Account() {
    }

    public Account(int id, String accNo, int password, BigDecimal balance, String name) {
        this.id = id;
        this.accNo = accNo;
        this.password = password;
        this.balance = balance;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accNo='" + accNo + '\'' +
                ", password=" + password +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }
}
