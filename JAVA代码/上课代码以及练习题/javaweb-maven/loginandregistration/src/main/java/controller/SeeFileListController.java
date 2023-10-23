package controller;

import mapper.KfmFileMapper;
import model.KfmFile;
import utils.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：controller
 * @文件名称：SeeController
 * @代码功能：从数据库查询上传的文件信息
 * @时间：2023/10/21/16:52
 */

@WebServlet("/fileList")
public class SeeFileListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 用户必须得登录
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser == null) {
            // 向前端响应登录成功页面
            resp.setHeader("content-type", "text/html;charset=utf-8");
            //获取字符输出流将内容输出到浏览器
            resp.getWriter().write("<script>alert('请先登录'); window.location.href='/login';</script>");
            return;
        }
        // 获取上传的文件夹中的所有列表并渲染到客户端
        KfmFileMapper kfmFileMapper = new KfmFileMapper();
        List<KfmFile> kfmFiles = kfmFileMapper.selectAll();
        // 渲染
        resp.getWriter().write(getHtml(kfmFiles));
    }

    private static String getHtml(List<KfmFile> kfmFiles) {
        if (kfmFiles != null && kfmFiles.size() > 0) {
            StringBuilder html = new StringBuilder("<html><body>");
            html.append("<table><tr><th>编号")
                    .append("</th><th>文件名称")
                    .append("</th><th>文件大小")
                    .append("</th><th>上传时间")
                    .append("</th><th>上传地址")
                    .append("</th><th>下载链接")
                    .append("</th></tr>");
            for (KfmFile kfmFile : kfmFiles) {
                html.append("<tr><td>").append(kfmFile.getId()).append("</td><td>")
                        .append(kfmFile.getName()).append("</td><td>")
                        .append(FileUtils.getSize(kfmFile.getSize())).append("KB").append("</td><td>")
                        .append(kfmFile.getCreateTime()).append("</td><td>")
                        .append(kfmFile.getUploadIp()).append("</td><td>")
                        .append("<a href='" + kfmFile.getDownloadLink() + "'>下载</a>").append("</td><td>").
                        append("</tr>");
            }

            html.append("</table></body></html>");
            return html.toString();
        }
        return "<h3>文件列表为空！</h3>";
    }
}

