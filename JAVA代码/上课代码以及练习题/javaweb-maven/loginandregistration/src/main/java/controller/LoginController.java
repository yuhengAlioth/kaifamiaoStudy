package controller;

import com.wf.captcha.utils.CaptchaUtil;
import model.KfmUser;
import service.KfmUserService;
import utils.FileUtils;
import utils.TimeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：controller
 * @文件名称：LoginServlet
 * @代码功能：登录服务
 * @时间：2023/10/21/9:45
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    private KfmUserService kfmUserService = new KfmUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String captcha = req.getParameter("captcha");

        boolean ver = CaptchaUtil.ver(captcha, req);
        if (ver) {
            CaptchaUtil.clear(req);
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            // 登录时间格式化
            String loginTime  = TimeUtils.getTwentyfourHourSystemTime(new Date());
            // 调用service处理登录业务 返回登录成功的用户对象
            KfmUser login = kfmUserService.login(username, password,loginTime);


            if (login == null) {
                System.out.println("账户或密码错误/用户不存在");
                resp.setHeader("content-type", "text/html;charset=utf-8");
                resp.getWriter().write("<script>alert('账户或密码错误/用户不存在'); window.location.href='/login';</script>");
            } else {
                // 将登录的用户存储到session中
                HttpSession session = req.getSession();
                session.setAttribute("loginUser", login);

                String name = login.getName();
                //创建Cookie
                Cookie cookie = new Cookie(URLEncoder.encode("name", StandardCharsets.UTF_8), URLEncoder.encode(name, StandardCharsets.UTF_8));
                //设置Cookie的最大生命周期,否则浏览器关闭后Cookie即失效
                cookie.setMaxAge(Integer.MAX_VALUE);
                //将Cookie加到response中
                resp.addCookie(cookie);

                // 向前端响应登录成功页面
                resp.setHeader("content-type", "text/html;charset=utf-8");
                //获取字符输出流将内容输出到浏览器
                resp.getWriter().write("<script>alert('登录成功'); window.location.href='"+req.getContextPath()+"/index';</script>");
            }
        }else {
            CaptchaUtil.clear(req);
            System.out.println("验证码错误");
            resp.setHeader("content-type", "text/html;charset=utf-8");
            resp.getWriter().write("<script>alert('验证码错误'); window.location.href='/login';</script>");
//            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}

