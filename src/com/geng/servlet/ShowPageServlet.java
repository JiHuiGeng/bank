package com.geng.servlet;

import com.geng.service.LogService;
import com.geng.service.impl.LogServiceImpl;
import com.geng.utils.PageHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * log分页控制层
 */
@WebServlet(value = {"/show"})
public class ShowPageServlet extends HttpServlet {
    private LogService logService = new LogServiceImpl();

    /**
     * 分页控制
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //设置默认每行显示数
        int pageSize = 2;
        //从前端获取pageSize
        String pageSizeStart = req.getParameter("pageSize");
        //当获取到非空值时,给pageSize赋值
        if (pageSizeStart != null && !(pageSizeStart).equals("")) {
            pageSize = Integer.parseInt(pageSizeStart);
        }
        //设置初始页面
        int pageNumber = 1;
        //从前端获取pageNumber
        String pageNumberStr = req.getParameter("pageNumber");
        //当获取到非空值时,给pageNumber赋值
        if (pageNumberStr != null && !(pageNumberStr).equals("")) {
            pageNumber = Integer.parseInt(pageNumberStr);
        }
        //pageSize pageNumber
        PageHelper pageHelper = logService.showPage(pageSize, pageNumber);
        //然后，把值传给作用域
        req.setAttribute("pageHelper", pageHelper);
        //请求转发
        req.getRequestDispatcher("/log.jsp").forward(req, res);
    }
}
