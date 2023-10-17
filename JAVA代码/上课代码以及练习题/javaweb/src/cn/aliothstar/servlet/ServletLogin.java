package cn.aliothstar.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：ServletLogin
 * @代码功能：登录demo
 * @时间：2023/10/16/16:34
 */
@WebServlet(urlPatterns = "/login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //使用request对象 获取请求数据
        String name = request.getParameter("name");//url?name=zhangsan
        // 使用response对象 设置响应数据
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.getWriter().write("<h1>" + name + ",欢迎您！</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("method：" + request.getMethod());
        System.out.println("query：" + request.getQueryString());
        // 返回字符流输入流
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line); // username=aa&password=11
        }
    }
}

