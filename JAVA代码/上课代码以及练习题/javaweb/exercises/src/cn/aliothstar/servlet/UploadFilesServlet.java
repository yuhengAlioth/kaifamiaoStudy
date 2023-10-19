package cn.aliothstar.servlet;

import cn.aliothstar.dao.UploadLogDao;
import cn.aliothstar.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：UploadFilesServlet
 * @代码功能：上传多个文件
 * @时间：2023/10/18/16:46
 */

@WebServlet("/uploadFiles")
@MultipartConfig
public class UploadFilesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("客户端或最后一个代理的IP源端口" + req.getRemotePort());
        System.out.println(req.getLocalName());
        System.out.println("IP地址" + req.getLocalAddr());
        System.out.println("端口号" + req.getLocalPort());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req.getPart("file");// 获取上传的一个文件
        req.setCharacterEncoding("UTf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        // 获取多个文件
        Collection<Part> parts = req.getParts();
        String downloadLinks = "";
        String message = "";
        for (Part part : parts) {
            String type = part.getContentType();
            String name = part.getSubmittedFileName();
            if (Constant.ALLOW_TYPES.contains(type)) {
                String fileName = Constant.UPLOAD_PATH + File.separator + name;
                File file = new File(fileName);
                // 如果目录不存在就去创建目录
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                part.write(fileName);
                downloadLinks += "<a href='/exercises/download?file=" + name + "'>下载" + name.substring(0, name.lastIndexOf(".")) + "</a><br>";
                message += "<p>" + name + "上传成功</p>";
            } else {
                message += "<p>" + name + "上传失败，文件格式不支持</p>";
            }
        }
        String html = "<html><body>";
        html += message;
        html += "<p>下载地址如下：</p>";
        html += downloadLinks;
        html += "</body></html>";
        resp.getWriter().write(html);


    }
}

