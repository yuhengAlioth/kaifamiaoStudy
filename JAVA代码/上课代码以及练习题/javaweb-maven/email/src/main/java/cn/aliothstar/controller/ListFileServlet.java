package cn.aliothstar.controller;

import cn.aliothstar.utils.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.controller
 * @文件名称：ListFileServlet
 * @代码功能：
 * @时间：2023/10/20/22:36
 */

@WebServlet("/list")
public class ListFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 用户必须得登录
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser == null) {
            resp.getWriter().write("<h3 style='color:red;'>请先登录</h3>");
            return;
        }
        // 获取上传的文件夹中的所有列表并渲染到客户端
        File[] files = FileUtils.getFiles();
        // 渲染
        resp.getWriter().write(getHtml(files));
    }

    private static String getHtml(File[] files) {
        if (files != null && files.length > 0) {
            StringBuilder html = new StringBuilder("<html><body>");
            html.append("<table><tr><th>文件名")
                    .append("</th><th>文件大小")
                    .append("</th><th>修改时间")
                    .append("</th></tr>");
            for (File file : files) {
                html.append("<tr><td>").append(file.getName()).append("</td><td>")
                        .append(file.length()).append("</td><td>").append(file.lastModified()).
                        append("</td>");
            }
            html.append("</table></body></html>");
            return html.toString();
        }
        return "<h3>文件列表为空！</h3>";
    }
}
