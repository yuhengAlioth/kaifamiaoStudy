package cn.aliothstar.servlet;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：ServletDemo6
 * @代码功能：精确匹配
 * @时间：2023/10/16/15:19
 */
@WebServlet(urlPatterns = "/user/select")
public class ServletDemo6 extends MyServlet {
    @Override
    protected void doGet(ServletRequest req, ServletResponse res) {
        System.out.println("demo6 get...");
    }
    @Override
    protected void doPost(ServletRequest req, ServletResponse res) {
    }
}

