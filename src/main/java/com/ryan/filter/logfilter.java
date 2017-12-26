package com.ryan.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by ryan
 */
public class logfilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        String site = filterConfig.getInitParameter("Site");
        System.out.println("网站名称: " + site);

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("该每访问一次就执行一次");

        // 把请求传回过滤链
        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
