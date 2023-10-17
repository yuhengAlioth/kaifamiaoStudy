package cn.aliothstar.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：ServletDemo1
 * @代码功能：注解形式
 * @时间：2023/10/16/11:23
 */
@WebServlet("/demo1")
public class ServletDemo1 implements Servlet {
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
        System.out.println("注解形式");
    }
    @Override
    public String getServletInfo() {
        return null;
    }
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}

