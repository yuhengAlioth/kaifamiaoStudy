package cn.aliothstar.servlet;

import cn.aliothstar.dao.UsersDao;
import cn.aliothstar.entity.Users;

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
 * @文件名称：RegisterServlet
 * @代码功能：注册服务
 * @时间：2023/10/16/20:44
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UsersDao userDao = new UsersDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 显示静态页面
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/register.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取前端的请求参数 post 字节流获取字符流获取请求参数 getReader()
        // 将获取流的编码格式修改成 utf-8
        req.setCharacterEncoding("UTF-8"); // 将tomcat获取流的编码格式设置成 UTF-8

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String email = req.getParameter("email");

        if (password.equals(confirmPassword)) {

            Users selectUser = userDao.selectByUsername(username);

            if (selectUser == null) {
                boolean user = userDao.registerUserInfo(username, password, email);
                if (user) {
                    System.out.println("注册成功");
                    // 设置状态码
                    resp.setStatus(200);
                    //设置响应头
                    resp.setHeader("content-type", "text/html;charset=utf-8");
                    //获取字符输出流将内容输出到浏览器
                    resp.getWriter().write("<script>alert('注册成功'); window.location.href='login.html';</script>");
                    // 重定向到登录页面
//                resp.sendRedirect(req.getContextPath() + "/login");
                } else {
                    System.out.println("注册失败");
                    // 重定向到登录页面
                    resp.setHeader("content-type", "text/html;charset=utf-8");
                    resp.getWriter().write("<script>alert('注册失败'); window.location.href='register.html';</script>");
                }
            } else {
                resp.setHeader("content-type", "text/html;charset=utf-8");
                resp.getWriter().write("<script>alert('该用户名已经被注册，请重新注册！！！'); window.location.href='register.html';</script>");
            }

        } else {
            resp.setHeader("content-type", "text/html;charset=utf-8");
            resp.getWriter().write("<script>alert('两次密码不一致！'); window.location.href='register.html';</script>");
        }

    }


}

