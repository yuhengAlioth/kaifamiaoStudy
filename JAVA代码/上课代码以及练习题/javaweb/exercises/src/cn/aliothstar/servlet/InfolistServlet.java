package cn.aliothstar.servlet;

import cn.aliothstar.dao.InfolistDao;
import cn.aliothstar.entity.Infolist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：InfolistServlet
 * @代码功能：
 * @时间：2023/10/17/18:59
 */
@WebServlet("/infolist")
public class InfolistServlet extends HttpServlet {
    private InfolistDao infolistDao = new InfolistDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/infolist.html").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询数据库信息
        List<Infolist> infolists = infolistDao.selectAll();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String html = "<style>\n" +
                "table {\n" +
                "  border-collapse: collapse;\n" +
                "  width: 100%;\n" +
                "  border: 1px solid #ddd;\n" +
                "}\n" +
                "th, td {\n" +
                "  border: 1px solid #ddd;\n" +
                "  padding: 8px;\n" +
                "  text-align: left;\n" +
                "}\n" +
                "</style>";
        html += "<table class='table table-bordered'>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th>id</th>\n" +
                "<th>管理员email</th>\n" +
                "<th>服务器url</th>\n" +
                "<th>文件列表</th>\n" +
                "</tr>\n" +
                "</thead>\n";
        for (Infolist infolist : infolists) {
            html += "<tr>\n" +
                    "<td>" + infolist.getId() + "</td>\n" +
                    "<td>" + infolist.getE_mail() + "</td>\n" +
                    "<td>" + infolist.getUrl() + "</td>\n" +
                    "<td>" + infolist.getFilelist() + "</td>\n" +
                    "</tr>\n";
        }
        html += "</table>";
        PrintWriter writer = resp.getWriter();
        writer.write(html);
        writer.flush();
        writer.close();
    }
}

