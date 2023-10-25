package cn.aliothstar.servlet;

import cn.aliothstar.utils.Constant;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.servlet
 * @文件名称：OfflineServlet
 * @代码功能：
 * @时间：2023/10/25/15:22
 */
@WebServlet("/offline")
public class OfflineServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        // 获取session对象
        ServletContext app = req.getServletContext();
        ConcurrentHashMap<String, HttpSession> map = (ConcurrentHashMap<String, HttpSession>)
                app.getAttribute(Constant.ONLINE_KEY);
        // 从存储在线人数的集合中删除当前
        HttpSession remove = map.remove(id);
        if (remove != null) {
            // 让session过期
            remove.invalidate();
        }
        resp.sendRedirect("/online");
    }
}
