package com.SpringDeneme.SpringDemo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/TestServlet")
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.getWriter().write(" Geçişten Önce... ");
        chain.doFilter(request,response);
        response.getWriter().write(" Yüklendikten sonra... ");
    }

    @Override
    public void destroy() {

    }
}
