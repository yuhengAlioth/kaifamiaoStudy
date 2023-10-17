package cn.aliothstar.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：ServletDemo8
 * @代码功能：扩展名匹配：*.mp3
 * @时间：2023/10/16/15:33
 */
@WebServlet(urlPatterns = "*.mp3")
public class ServletDemo8 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("demo8 get...");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
    }
}

