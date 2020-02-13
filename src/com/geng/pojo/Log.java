package com.geng.pojo;

import java.math.BigDecimal;

/**
 * 日志
 */
public class Log {
    /**
     * 账户编号
     */
    private int id;
    /**
     * 转入账户
     */
    private String inAccNo;
    /**
     * 转出账户
     */
    private String outAccNo;
    /**
     * 金额
     */
    private BigDecimal money;

    public Log() {
    }

    public Log(int id, String inAccNo, String outAccNo, BigDecimal money) {
        this.id = id;
        this.inAccNo = inAccNo;
        this.outAccNo = outAccNo;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInAccNo() {
        return inAccNo;
    }

    public void setInAccNo(String inAccNo) {
        this.inAccNo = inAccNo;
    }

    public String getOutAccNo() {
        return outAccNo;
    }

    public void setOutAccNo(String outAccNo) {
        this.outAccNo = outAccNo;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
