package cn.aliothstar.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.util.Enumeration;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：ServletDemo2
 * @代码功能：Servlet生命周期方法
 * @时间：2023/10/16/11:27
 */
@WebServlet(urlPatterns = "/demo2", loadOnStartup = 1)
public class ServletDemo2 implements Servlet {
    /**
     * 初始化方法
     * 1.调用时机：默认情况下，Servlet被第一次访问时，调用
     * * loadOnStartup: 默认为-1，修改为0或者正整数，则会在服务器启动的时候，调用
     * 2.调用次数: 1次
     *
     * @param config
     * @throws ServletException
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println(config.getServletName());
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            System.out.println(initParameterNames.nextElement());
        }
        System.out.println("init...");
    }
    /**
     * 提供服务
     * 1.调用时机:每一次Servlet被访问时，调用
     * 2.调用次数: 多次
     *
     * @param req
     * @param res
     * @throws ServletException
     */
    public void service(ServletRequest req, ServletResponse res) throws ServletException
    {
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
    public ServletConfig getServletConfig() {
        return null;
    }
    public String getServletInfo() {
        return null;
    }
}

