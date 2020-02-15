package com.geng.mapper;

import com.geng.pojo.Log;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * LogMapper
 */
@Component("logMapper")
public interface LogMapper {

    /**
     * selectCount
     *
     * @return
     */
    int selectCount();

    /**
     * selectPage
     *
     * @param map
     * @return
     */
    List<Log> selectPage(Map<String, Object> map);


    /**
     * insertLog
     *
     * @param log
     * @return
     */
    int insertLog(Log log);
}
