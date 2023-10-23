package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：controller
 * @文件名称：LogoutServlet
 * @代码功能：退出登录
 * @时间：2023/10/21/10:19
 */

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        // 获取session
        HttpSession session = req.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser == null) {
            resp.getWriter().write("<h3>请先登录</h3>");
            return;
        }
        session.removeAttribute("loginUser");
        session.invalidate();
        resp.sendRedirect("/index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

