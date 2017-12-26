package com.ryan.life;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ryan
 */
public class ServletLifeCycleExample extends HttpServlet {
    private int count;

    @Override
    public void init(final ServletConfig config) throws ServletException {

        System.out.println("servletname:"+config.getServletName());//得到你这个servlet的名字（web.xml映射的那个名字）
        System.out.println("servletContext:"+config.getServletContext());
        System.out.println("getInitParameter:方法"+config.getInitParameter("g_name"));//这个参数不是指全局的，而是servlet容器内部的
        System.out.println("InitParameterNames方法"+config.getInitParameterNames());
        while(config.getInitParameterNames().hasMoreElements()){
            //返回的是一个Enumeration对象，这里可以针对servlet内部设置的 参数无限循环
            System.out.println("方法："+config.getInitParameterNames().nextElement());
        }
        System.out.println("**********init 被调用了*****************");//方法：encoding


        super.init(config);
        getServletContext().log("init() called");
        count = 0;
    }

    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        getServletContext().log("service() called");
        count++;
        response.getWriter().write("Incrementing the count to " + count);
    }

    @Override
    public void destroy() {
        getServletContext().log("destroy() called");
    }
}
