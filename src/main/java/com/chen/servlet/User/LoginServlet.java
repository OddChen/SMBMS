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
 * @date 2022/8/17
 */
public class LoginServlet extends HttpServlet {
//    控制层调用业务层代码
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet----start----");
//        将前端传过来的密码同数据库中的进行对比，数据库中的密码通过业务层去获取
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        UserService userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);

        if (user != null) {
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            resp.sendRedirect("jsp/frame.jsp");
        } else {
            req.setAttribute("error", "username is wrong!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
