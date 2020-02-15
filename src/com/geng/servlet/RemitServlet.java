package com.geng.servlet;

import com.geng.pojo.Account;
import com.geng.service.AccountService;
import com.geng.service.impl.AccountServiceImpl;
import com.geng.utils.StatusForFirm;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * 转账控制层
 */
@WebServlet("/remit")
public class RemitServlet extends HttpServlet {
    private AccountService accountService;
    private StatusForFirm statusForFirm;

    /**
     * 初始化
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        //将tomcat启动时加载的xml资源取出
        WebApplicationContext requiredWebApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        //获取其中accountService所属资源
        accountService = requiredWebApplicationContext.getBean("accountService", AccountServiceImpl.class);
    }

    /**
     * 转账
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //实例化一个转出账户对象
        Account accountOut = new Account();
        //前端传来的转出账户
        accountOut.setAccNo(req.getParameter("outAccNo"));
        //前段传来的转出账户所属密码
        accountOut.setPassword(Integer.parseInt(req.getParameter("outPassword")));
        //前端传入String类型，转为BigDecimal
        BigDecimal outBalance = new BigDecimal(req.getParameter("outBalance"));
        accountOut.setBalance(outBalance);
        //实例化一个转入账户对象
        Account accountIn = new Account();
        //前端传来的转入账户
        accountIn.setAccNo(req.getParameter("inAccNo"));
        //前端传来的转入账户所属姓名
        accountIn.setName(req.getParameter("inName"));
        //调用accountService下的remit方法
        int returnCode = accountService.remit(accountIn, accountOut);

        if (returnCode == statusForFirm.SUCCESS) {
            //如果返回成功跳转log页面
            res.sendRedirect("/bank/show");
        } else {
            //失败跳转error页面
            HttpSession session = req.getSession();
            //session设置返回码
            session.setAttribute("code", returnCode);
            res.sendRedirect("/bank/error.jsp");
        }
    }
}
