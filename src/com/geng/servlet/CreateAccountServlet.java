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
 * CreateAccountServlet
 */
@WebServlet(value = {"/create"})
public class CreateAccountServlet extends HttpServlet {
    private StatusForFirm statusForFirm;

    private AccountService accountService;

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
        int password = Integer.parseInt(req.getParameter("password"));
        BigDecimal balance = new BigDecimal(req.getParameter("balance"));
        String name = req.getParameter("name");
        Account account = new Account();
        account.setAccNo(accNo);
        account.setPassword(password);
        account.setBalance(balance);
        account.setName(name);
        String returnCode = accountService.createAccount(account);
        if (returnCode == statusForFirm.SUCCESS) {
            HttpSession session = req.getSession();
            session.setAttribute("name", account.getName());
            req.getRequestDispatcher("/login").forward(req, res);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("code", returnCode);
            req.getRequestDispatcher("/error.jsp").forward(req, res);
        }

    }
}
