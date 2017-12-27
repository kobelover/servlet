package com.ryan.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ryan
 */
public class CookieExample extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        response.setContentType("text/plain;charset=UTF-8");
        Cookie[] cookies = request.getCookies();
        //get
        PrintWriter pw = response.getWriter();

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("==========================cookies length："+cookies.length+"================\n");
        stringBuffer.append("===============浏览器可以传到服务端cookies变量"+"================\n");
        for (Cookie cookie : cookies) {
            stringBuffer.append("cookie.clone()----------:"+cookie.clone()+"\n");
            stringBuffer.append("cookie.getComment()----------:"+cookie.getComment()+"\n");
            stringBuffer.append("cookie.getDomain()----------:"+cookie.getDomain()+"\n");
            stringBuffer.append("cookie.getMaxAge()----------:"+cookie.getMaxAge()+"\n");
            stringBuffer.append("cookie.getName()----------:"+cookie.getName()+"\n");
            stringBuffer.append("cookie.getPath()----------:"+cookie.getPath()+"\n");
            stringBuffer.append("cookie.getSecure()----------:"+cookie.getSecure()+"\n");
            stringBuffer.append("cookie.getValue()----------:"+cookie.getValue()+"\n");
            stringBuffer.append("cookie.getVersion()----------:"+cookie.getVersion()+"\n");
            stringBuffer.append("cookie.isHttpOnly()----------:"+cookie.isHttpOnly()+"\n");
        }
        // 创建Cookie
        Cookie cookie = new Cookie("CookieName", "CookieValue");
        cookie.setComment("this is set comment");
//        cookie.setDomain("localhost.com");
//        cookie.setPath("/cookie/path");
//        cookie.setSecure(true);
        //cookie.setValue("this is set value");  Assigns a new value to a cookie after the cookie is created.
        cookie.setMaxAge(10);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        pw.write(String.valueOf(stringBuffer));
    }
}
