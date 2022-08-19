package com.chen.servlet.User;

import com.chen.pojo.User;
import com.chen.service.user.UserService;
import com.chen.service.user.UserServiceImpl;
import com.chen.util.Constants;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author chenxingyu
 * @date 2022/8/18
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        System.out.println(method + "-- start --");

        if (method != null && method.equals("updatepwd")) {
            this.updatePwd(req, resp);
        } else if (method != null && method.equals("pwdmodify")) {
            this.pwdModify(req, resp);
        }
    }

    private void updatePwd(HttpServletRequest req, HttpServletResponse resp) {
        int result = 0;

        User userId = (User) req.getSession().getAttribute(Constants.USER_SESSION);
        String password = req.getParameter("userpassword");

        UserService userService = new UserServiceImpl();
        result =  userService.updateUserPwd(userId.getId(), password);
        if (result != 0) {
            req.setAttribute("message", "update complete!");
        } else {
            req.setAttribute("message", "update failed!");
        }
    }

    private void pwdModify(HttpServletRequest req, HttpServletResponse resp) {

    }
}
