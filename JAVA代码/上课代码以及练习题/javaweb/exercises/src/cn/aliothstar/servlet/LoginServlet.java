package cn.aliothstar.servlet;

import cn.aliothstar.dao.UsersDao;
import cn.aliothstar.entity.Users;
import com.wf.captcha.utils.CaptchaUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：LoginServlet
 * @代码功能：登录服务
 * @时间：2023/10/16/19:19
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UsersDao userDao = new UsersDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 显示静态页面
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取前端的请求参数 post 字节流获取字符流获取请求参数 getReader()
        // 将获取流的编码格式修改成 utf-8
        req.setCharacterEncoding("UTF-8"); // 将tomcat获取流的编码格式设置成 UTF-8

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String captcha = req.getParameter("captcha");


        boolean ver = CaptchaUtil.ver(captcha, req);
        if (!ver) {
            CaptchaUtil.clear(req);
            System.out.println("验证码错误");
            resp.sendRedirect(req.getContextPath() + "/login");
        }


//        System.out.println("username = " + username);
//        System.out.println("password = " + password);

        if (username != null && password != null ) {
            // TODO 和数据库内容做比较
            Users user = userDao.selectByUsernameAndPassword(username, password);
            if (user == null) {
                System.out.println("登录失败");
                resp.setHeader("content-type", "text/html;charset=utf-8");
                resp.getWriter().write("<script>alert('用户名或密码错误'); window.location.href='login.html';</script>");
            } else {
                System.out.println("登录成功");
                // 重定向到登录页面
                //设置响应头
                resp.setHeader("content-type", "text/html;charset=utf-8");
                //获取字符输出流将内容输出到浏览器
//                resp.getWriter().write("<script>alert('登录成功'); window.location.href='index.html';</script>");
                resp.sendRedirect(req.getContextPath() + "/index");
            }
        } else {
            System.out.println("账户或密码不能为空");
            resp.setHeader("content-type", "text/html;charset=utf-8");
            resp.getWriter().write("<script>alert('账户或密码不能为空'); window.location.href='login.html';</script>");
        }
    }


}

