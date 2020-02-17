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

/**
 * LoginServlet
 */
@WebServlet(value = {"/login"})
public class LoginServlet extends HttpServlet {

    private AccountService accountService;
    private StatusForFirm statusForFirm;

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        accountService = webApplicationContext.getBean("accountService", AccountServiceImpl.class);
    }

    /**
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String accNo = req.getParameter("accNo");
        String password = req.getParameter("password");
        Account account = new Account();
        account.setAccNo(accNo);
        account.setPassword(Integer.parseInt(password));
        Account loginAccount = accountService.login(account);
        HttpSession session = req.getSession();
        if (loginAccount != null && !loginAccount.equals("")) {
            session = req.getSession();
            session.setAttribute("name", loginAccount.getName());
            session.setAttribute("code", statusForFirm.ERROR);
            req.getRequestDispatcher("/remit.jsp").forward(req, res);

        } else {
            //session设置返回码
            session.setAttribute("code", statusForFirm.ERROR);
            req.getRequestDispatcher("/error.jsp").forward(req, res);
        }
    }
}
