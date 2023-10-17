package cn.aliothstar.servlet;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：ServletDemo7
 * @代码功能：urlPattern: 一个Servlet可以配置多个访问路径
 * @时间：2023/10/16/15:13
 */
@WebServlet(urlPatterns = {"/demo5","/demo55"})
public class ServletDemo5 extends MyServlet {
    @Override
    protected void doGet(ServletRequest req, ServletResponse res) {
        System.out.println("demo5 get...");
    }
    @Override
    protected void doPost(ServletRequest req, ServletResponse res) {
    }
}

