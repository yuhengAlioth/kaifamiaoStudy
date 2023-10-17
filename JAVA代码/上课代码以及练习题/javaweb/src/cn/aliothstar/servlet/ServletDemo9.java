package cn.aliothstar.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：ServletDemo9
 * @代码功能：任意匹配：/
 * @时间：2023/10/16/16:10
 */
//@WebServlet(urlPatterns = "/")
public class ServletDemo9 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("demo9 get...");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
    }
}

