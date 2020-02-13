package com.geng.service;

import com.geng.utils.PageHelper;

import java.io.IOException;

/**
 * 日志服务接口
 */
public interface LogService {
    /**
     * 分页
     *
     * @param pageSize
     * @param pageNumber
     * @return PageHelper
     * @throws IOException
     */
    public PageHelper showPage(int pageSize, int pageNumber) throws IOException;
}
