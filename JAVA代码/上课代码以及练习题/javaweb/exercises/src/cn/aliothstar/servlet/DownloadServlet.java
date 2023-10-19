package cn.aliothstar.servlet;

import cn.aliothstar.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：DownloadServlet
 * @代码功能：下载文件服务
 * @时间：2023/10/18/14:29
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/download.html").forward(req,resp);
        // 告诉浏览器响应的是二进制流
        resp.setContentType("application/octet-stream");
        // 获取本次下载文件的名称
        String file = req.getParameter("file");
        // 设置以附件的形式下载，指定下载的名字是文件原来的名字
        resp.setHeader("content-disposition", "attachment; filename=" + file);
        // 要下载的文件的完整路径
        String path = Constant.UPLOAD_PATH + File.separator + file;
        FileInputStream in = new FileInputStream(path);
        // 获取响应的输出流
        ServletOutputStream out = resp.getOutputStream();
        // 将文件内容写入到输出流
        in.transferTo(out);
        out.flush();
        out.close();
        in.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

