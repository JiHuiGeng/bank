package com.geng.mapper;

import com.geng.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * AccountMapper
 */
@Component("accountMapper")
public interface AccountMapper {

    /**
     * selectByAccNoAndPW
     *
     * @param account
     * @return
     */
    Account selectByAccNoAndPW(Account account);


    /**
     * selectByAccNoAndName
     *
     * @param account
     * @return
     */
    Account selectByAccNoAndName(Account account);

    /**
     * selectById
     *
     * @param id
     * @return
     */
    Account selectById(int id);


    /**
     * selectAll
     *
     * @return
     */
    List<Account> selectAll();


    /**
     * updateBalanceByAccNo
     *
     * @param account
     * @return
     */
    int updateBalanceByAccNo(Account account);
}
