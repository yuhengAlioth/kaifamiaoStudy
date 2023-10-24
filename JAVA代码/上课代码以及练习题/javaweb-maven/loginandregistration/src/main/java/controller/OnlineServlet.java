package controller;

import model.KfmUser;
import utils.Constant;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：controller
 * @文件名称：OnlineServlet
 * @代码功能：在线人数
 * @时间：2023/10/24/10:45
 */
@WebServlet("/online")
public class OnlineServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取登录用户的数量 --> ServletContext 中的值
        ServletContext servletContext = req.getServletContext();
        List<KfmUser> list = (List<KfmUser>) servletContext.getAttribute(Constant.ONLINE_KEY);
        resp.setContentType("text/html;charset=utf-8");
        StringBuilder html = new StringBuilder("<h2>在线人数" + list.size() + "</h2>");
        for (KfmUser s : list) {

            html.append("<p>").append(s.getName()).append("</p>");
        }
        resp.getWriter().write(html.toString());

    }
}

