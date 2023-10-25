package cn.aliothstar.servlet;

import cn.aliothstar.model.KfmUser;
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
 * @文件名称：OnlineServlet
 * @代码功能：
 * @时间：2023/10/25/15:23
 */
@WebServlet("/online")
public class OnlineServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取登录用户的数量 --> ServletContext 中的值
        ServletContext servletContext = req.getServletContext();
        // 获取存储的在线用户
        ConcurrentHashMap<String, HttpSession> map = (ConcurrentHashMap<String, HttpSession>)
                servletContext.getAttribute(Constant.ONLINE_KEY);
        resp.setContentType("text/html;charset=utf-8");
        StringBuilder html = new StringBuilder("<h2>在线人数" + map.size() + "</h2>");
        html.append("<table>").append("<tr><td>id</td><td>用户名</td><td>操作</td></tr>");
        map.forEach((k, v) -> {
            KfmUser user = (KfmUser) v.getAttribute(Constant.LOGIN_USER_KEY);
            String link = "<a href='/offline?id=" + k + "'> 下线</a>";
            html.append("<tr><td>").append(k).append("</td><td>").append(user.getUsername()).append("</td><td>").append(link).append("</td></tr>");
        });
        html.append("</table>");
        resp.getWriter().write(html.toString());

    }
}

