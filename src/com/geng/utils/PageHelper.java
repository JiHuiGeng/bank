package com.geng.utils;

import java.util.List;

/**
 * 分页工具
 */
public class PageHelper {
    /**
     * 当前页
     */
    private int pageNumber;
    /**
     * 一页几行
     */
    private int pageSize;
    /**
     * 总行数
     */
    private int total;
    /**
     * 每页显示的log数据
     */
    private List<?> list;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
