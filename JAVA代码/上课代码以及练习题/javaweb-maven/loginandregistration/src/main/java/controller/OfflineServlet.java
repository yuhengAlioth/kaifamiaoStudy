package controller;

import model.KfmUser;
import utils.Constant;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：controller
 * @文件名称：OfflineServlet
 * @代码功能：强制下线
 * @时间：2023/10/25/10:38
 */
@WebServlet("/offline")
public class OfflineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取用户ID作为查询参数
        String userId = req.getParameter("id");
        if (userId != null) {
            HttpSession session = req.getSession();
            ServletContext servletContext = req.getServletContext();
            List<KfmUser> list = (List<KfmUser>) servletContext.getAttribute(Constant.ONLINE_KEY);

            // 在线用户列表中查找用户
            KfmUser user = null;
            List<KfmUser> usersToRemove = new ArrayList<>();
            for (KfmUser u : list) {
                if (u.getId().toString().equals(userId)) {
                    user = u;
                    // 添加要删除的用户到集合中
                    usersToRemove.add(u);
                    break;
                }
            }

            // TODO 下线bug待修复

            // 判断用户ID是否为1，如果是则不进行下线操作，并给客户端返回一个提示信息
            if (user != null && !"1".equals(user.getId().toString())) {
                // 从在线用户列表中移除用户
                usersToRemove.forEach(list::remove);
                servletContext.setAttribute(Constant.ONLINE_KEY, list);  // 更新在线用户列表
                // 清除用户的session信息
                session.removeAttribute(Constant.LOGIN_USER_KEY);
                // 构建响应并发送给客户端
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("<script>alert('用户：" + user.getName() + " 已下线'); window.location.href='/online';</script>");
            } else {
                System.out.println("用户ID为1不能离线/找不到用户");
                // 如果用户ID为1，或者没有找到对应的用户，给客户端返回一个提示信息
                resp.setHeader("content-type", "text/html;charset=utf-8");
                resp.getWriter().write("<script>alert('用户ID为1不能离线/找不到用户'); window.location.href='/online';</script>");
            }
        } else {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("<script>alert('没有收到用户ID'); window.location.href='/online';</script>");
        }
    }
}
