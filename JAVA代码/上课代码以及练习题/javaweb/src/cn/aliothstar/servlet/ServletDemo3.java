package cn.aliothstar.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：ServletDemo3
 * @代码功能：Servlet方法介绍
 * @时间：2023/10/16/11:28
 */

@WebServlet(urlPatterns = "/demo3",loadOnStartup = 1)
public class ServletDemo3 implements Servlet {
    private ServletConfig servletConfig;
    /**
     * 初始化方法
     * 1.调用时机：默认情况下，Servlet被第一次访问时，调用
     * * loadOnStartup: 默认为-1，修改为0或者正整数，则会在服务器启动的时候，调用
     * 2.调用次数: 1次
     * @param config
     * @throws ServletException
     */
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
        System.out.println("init...");
    }
    public ServletConfig getServletConfig() {
        return servletConfig;
    }
    /**
     * 提供服务
     * 1.调用时机:每一次Servlet被访问时，调用
     * 2.调用次数: 多次
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void service(ServletRequest req, ServletResponse res) throws
            ServletException, IOException {
        System.out.println("servlet hello world~");
    }
    /**
     * 销毁方法
     * 1.调用时机：内存释放或者服务器关闭的时候，Servlet对象会被销毁，调用
     * 2.调用次数: 1次
     */
    public void destroy() {
        System.out.println("destroy...");
    }
    public String getServletInfo() {
        return "";
    }
}