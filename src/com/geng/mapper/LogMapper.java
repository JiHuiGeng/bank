package com.geng.mapper;

import com.geng.pojo.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

/**
 * LogMapper
 */
public interface LogMapper {
    /**
     * selectCount
     *
     * @return
     */
    @Select("SELECT COUNT(*) FROM log")
    int selectCount();

    /**
     * selectPage
     *
     * @param pageStart
     * @param pageSize
     * @return
     */
    @Select("SELECT * FROM log LIMIT #{pageStart},#{pageSize}")
    List<Log> selectPage(int pageStart, int pageSize);

    /**
     * insertLog
     *
     * @param inAccNo
     * @param outAccNo
     * @param money
     * @return
     */
    @Insert("INSERT INTO log VALUES(default ,#{inAccNo},#{outAccNo},#{money})")
    int insertLog(String inAccNo, String outAccNo, BigDecimal money);
}
