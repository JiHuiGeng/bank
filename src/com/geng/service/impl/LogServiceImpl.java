package com.geng.service.impl;

import com.geng.pojo.Log;
import com.geng.service.LogService;
import com.geng.utils.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日志业务逻辑实现类
 * 异常在service抛
 */
public class LogServiceImpl implements LogService {
    /**
     * 分页
     *
     * @param pageSize
     * @param pageNumber
     * @return PageHelper
     * @throws IOException
     */
    @Override
    public PageHelper showPage(int pageSize, int pageNumber) throws IOException {
        //先获取mybatis全局配置,转换字节流，以便接下来交给SqlSessionFactoryBuilder使用
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获得sqlSessionFactory,建造者模式
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Object> map = new HashMap<>();
        //分页查询
        map.put("pageStart", pageSize * (pageNumber - 1));//起始页
        map.put("pageSize", pageSize);//一页显示几行
        //查询log日志
        List<Log> list = sqlSession.selectList("com.geng.mapper.LogMapper.selectPage", map);
        int total = sqlSession.selectOne("com.geng.mapper.LogMapper.selectCount");
        PageHelper pageHelper = new PageHelper();
        //放入日志list
        pageHelper.setList(list);
        //放入当前页面
        pageHelper.setPageNumber(pageNumber);
        //放入每页显示行数
        pageHelper.setPageSize(pageSize);
        //总行数
        pageHelper.setTotal(total % pageSize == 0 ? total / pageSize : total / pageSize + 1);
        return pageHelper;
    }
}
