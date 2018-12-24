package com.baizhi.interceptor;

import com.baizhi.entity.Admin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Admin admin = (Admin) ((HttpServletRequest) request).getSession().getAttribute("admin");
        if(admin!=null){
            //放行
            chain.doFilter(request,response);
        }else{
            HttpServletResponse response1 = (HttpServletResponse) response;
            response1.sendRedirect(((HttpServletRequest) request).getContextPath()+"/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
