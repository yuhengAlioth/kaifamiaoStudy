package cn.aliothstar.servlet;

import cn.aliothstar.model.KfmUser;
import cn.aliothstar.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.servlet
 * @文件名称：LoginServlet
 * @代码功能：
 * @时间：2023/10/25/15:21
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 模拟登录操作
        String username = req.getParameter("username");
        req.getSession().setAttribute(Constant.LOGIN_USER_KEY, new KfmUser(username));
//        resp.setContentType("text/html;charset=utf-8");
//        resp.getWriter().write("<h1>" + username + ",你好，欢迎来到我的网站</h1>");
        resp.sendRedirect("/index");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.html").forward(req, resp);
    }
}

