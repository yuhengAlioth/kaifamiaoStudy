package cn.aliothstar.controller;

import cn.aliothstar.model.Users;
import cn.aliothstar.service.UserService;
import com.wf.captcha.utils.CaptchaUtil;

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
 * @包名：cn.aliothstar.controller
 * @文件名称：LoginServlet
 * @代码功能：
 * @时间：2023/10/20/22:36
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8;");
        String code = req.getParameter("verCode");
        System.out.println(code);
        if (CaptchaUtil.ver(code, req)) {
            CaptchaUtil.clear(req);
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            // 调用service处理登录业务 返回登录成功的用户对象
            Users login = userService.login(username, password);
            if (login == null) {
                resp.getWriter().write("<h3 style='color:red;'>登录失败</h3>");
                return;
            } else {
                // 将登录的用户存储到session中
                HttpSession session = req.getSession();
                session.setAttribute("loginUser", login);
                // 向前端响应登录成功页面
                resp.getWriter().write("<h3 style='color:green;'>登录成功</h3>");
            }
        } else {
            resp.getWriter().write("<h3 style='color:red;'>验证码失败</h3>");
        }
    }
}
