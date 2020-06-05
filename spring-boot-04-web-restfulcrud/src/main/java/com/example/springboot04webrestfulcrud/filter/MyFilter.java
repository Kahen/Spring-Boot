package com.example.springboot04webrestfulcrud.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 李家幸
 * @class 计科三班
 * @create 2020-01-06 11:08
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("my Filter process...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
