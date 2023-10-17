package cn.aliothstar.servlet;


import javax.servlet.*;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：MyServlet
 * @代码功能：
 * @时间：2023/10/16/10:26
 */

public abstract class MyServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        System.out.println("MyServlet ==> service");
    }
    @Override
    public String getServletInfo() {
        return null;
    }
    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    protected abstract void doGet(ServletRequest req, ServletResponse res);

    protected abstract void doPost(ServletRequest req, ServletResponse res);
}

