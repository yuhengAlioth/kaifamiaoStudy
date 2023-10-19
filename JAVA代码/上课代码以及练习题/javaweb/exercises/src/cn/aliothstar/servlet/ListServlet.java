package cn.aliothstar.servlet;

import cn.aliothstar.utils.Constant;
import cn.aliothstar.utils.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：ListServlet
 * @代码功能：查看上传文件夹内所有文件
 * @时间：2023/10/18/16:03
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询到服务器上传目录的所有文件并显示
        File file = new File(Constant.UPLOAD_PATH);
        // 将文件拿出来
        File[] files = file.listFiles(f -> f.isFile());

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        // 显示上传的目录中有文件
        if (files != null && files.length > 0) {
            // 拼接 html内容
            StringBuilder html = new StringBuilder("<table>");
            html.append("<tr>").append("<th>序号</th>").append("<th>文件名</th>").append("<th>文件大小</th>").append("<th>修改时间</th><th>操作</th></tr>");
            for (int i = 1; i <= files.length; i++) {
                File f = files[i - 1];
                html.append("<tr>").append("<td>").append(i).append("</td>");
                html.append("<td>").append(f.getName()).append("</td>");
                html.append("<td>").append(FileUtils.getSize(f.length())).append("KB").append("</td>");
                html.append("<td>").append(FileUtils.getTime(f.lastModified())).append("</td>");
                String downloadLink = "/exercises/download?file=" + f.getName();
                html.append("<td><a").append(" href=").append(downloadLink).append(">下载</a>").append("</td>").append("</tr>");
            }
            html.append("</table>");
            resp.getWriter().write(html.toString());
        } else {
            resp.getWriter().write("<h3>服务端上传目录为空</h3>");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
