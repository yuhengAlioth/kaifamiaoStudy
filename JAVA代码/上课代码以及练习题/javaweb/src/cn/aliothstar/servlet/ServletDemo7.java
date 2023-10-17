package cn.aliothstar.servlet;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：ServletDemo7
 * @代码功能：目录匹配：/user/*
 * @时间：2023/10/16/15:26
 */
@WebServlet(urlPatterns = "/user/*")
public class ServletDemo7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("demo7 get...");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
    }
}
