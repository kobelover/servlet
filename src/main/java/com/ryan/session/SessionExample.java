package com.ryan.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ryan
 */
public class SessionExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        HttpSession session = req.getSession();
        if (session.isNew()){
            session.setAttribute("name", "ryan");
            session.setAttribute("site", "localhost.com");
        }
        String id = session.getId();

        PrintWriter out = resp.getWriter();
        // 如果HttpSession是新建的话
        if (session.isNew()) {
            out.println("Hello,HttpSession! The first response - SessionId=" + id + "\n");

            out.println("The first-response - name: "
                    + session.getAttribute("name")+"-CreationTime:"+session.getCreationTime()
                    +"\n-LastAccessedTime:"+session.getLastAccessedTime()
                    +"\n-getAttributeNames:"+session.getAttributeNames()
                    +"\n-getServletContext:"+session.getServletContext()
            );
        } else {
            out.println("Hello,HttpSession! The second response - SessionId=" + id + "\n");

            out.println("The second-response - name: "
                    + session.getAttribute("name")+"-CreationTime:"+session.getCreationTime()
            +"\n-LastAccessedTime:"+session.getLastAccessedTime()
            +"\n-getAttributeNames:"+session.getAttributeNames()
            +"\n-getServletContext:"+session.getServletContext()
            );
        }

    }
}
