package com.chen.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author chenxingyu
 */
public class CharacterEncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException{

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
