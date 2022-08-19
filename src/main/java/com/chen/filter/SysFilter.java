package com.chen.filter;

import com.chen.pojo.User;
import com.chen.util.Constants;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author chenxingyu
 * @date 2022/8/18
 */
public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        if (user == null ) {
            response.sendRedirect("/SMBMS/error.jsp");
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void destroy() {

    }
}
