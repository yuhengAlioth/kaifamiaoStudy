package controller;

import model.KfmUser;
import utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

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

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();

            String decodeName = URLDecoder.decode(name, StandardCharsets.UTF_8);

            Cookie cookie1 = new Cookie(decodeName, null);
            cookie.setMaxAge(0); // 将过期时间设置为0，即立即过期
            cookie.setPath("/index"); // 设置cookie的路径，确保能够覆盖整个网站
            resp.addCookie(cookie1);
        }

        // 获取session
        HttpSession session = req.getSession();
        Object loginUser = session.getAttribute(Constant.LOGIN_USER_KEY);
        if (loginUser == null) {
//            resp.getWriter().write("<h3>请先登录</h3>");
            resp.setHeader("content-type", "text/html;charset=utf-8");
            resp.getWriter().write("<script>alert('确定退出吗?');window.location.href='/index';</script>");
            return;
        }
        session.removeAttribute(Constant.LOGIN_USER_KEY);
        session.invalidate();
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

