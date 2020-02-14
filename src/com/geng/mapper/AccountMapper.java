package com.geng.mapper;

import com.geng.pojo.Account;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

/**
 * AccountMapper
 */
public interface AccountMapper {
    /**
     * selectByAccNoAndPW
     *
     * @param accNo
     * @param password
     * @return
     */
    @Select("SELECT * FROM account WHERE accNo=? AND password=? ")
    Account selectByAccNoAndPW(String accNo, int password);

    /**
     * selectByAccNoAndName
     *
     * @param accNo
     * @param name
     * @return
     */
    @Select("SELECT * FROM account WHERE accNo=? AND name=?")
    Account selectByAccNoAndName(String accNo, String name);

    /**
     * selectById
     *
     * @param id
     * @return
     */
    @Select("SELECT * FROM account WHERE id=?")
    Account selectById(int id);

    /**
     * selectAll
     *
     * @return
     */
    @Select("SELECT * FROM account")
    List<Account> selectAll();

    /**
     * updateBalanceByAccNo
     *
     * @param balance
     * @param accNo
     * @return
     */
    @Update("UPDATE account SET balance=balance+#{balance} WHERE accNo=#{accNo};")
    int updateBalanceByAccNo(BigDecimal balance, String accNo);
}
