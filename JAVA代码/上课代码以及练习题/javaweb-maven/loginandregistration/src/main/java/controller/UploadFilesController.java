package controller;

import mapper.KfmFileMapper;
import utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：controller
 * @文件名称：UploadFilesController
 * @代码功能：上传多个文件
 * @时间：2023/10/21/15:54
 */
@WebServlet("/uploadFiles")
@MultipartConfig
public class UploadFilesController extends HttpServlet {

    private KfmFileMapper kfmFileMapper = new KfmFileMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();
        Object loginUser = session.getAttribute(Constant.LOGIN_USER_KEY);
        if (loginUser == null) {
            // 向前端响应登录成功页面
            resp.setHeader("content-type", "text/html;charset=utf-8");
            //获取字符输出流将内容输出到浏览器
            resp.getWriter().write("<script>alert('请先登录'); window.location.href='/login';</script>");
            return;
        }

        // 获取访问人的IP地址
        String uip = req.getRemoteHost();
        uip = "0:0:0:0:0:0:0:1".equals(uip) ? "127.0.0.1" : uip;
        // 获取服务IP地址
        String ip = req.getLocalAddr();
        ip = "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
        // 获取服务端口号
        int port = req.getLocalPort();
        // 获取项目的上下文路径
        String contextPath = req.getContextPath();
        // 获取多个文件
        Collection<Part> parts = req.getParts();
        String downloadLinks = "";
        String message = "";
        for (Part part : parts) {
            // 获取文件类型
            String type = part.getContentType();
            // 获取文件名称以及后缀名字
            String name = part.getSubmittedFileName();
            if (Constant.ALLOW_TYPES.contains(type)) {
                // 文件大小，初始设为-1
                long size = -1;
                // 文件上传时间，初始设为 null
                String createTime = "";


                String fileName = Constant.UPLOAD_PATH + File.separator + name;
                File file = new File(fileName);
                // 如果目录不存在就去创建目录
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }

                try {
                    // 将文件写入到指定位置
                    part.write(fileName);
                    // 获取文件大小
                    size = file.length();

                    // 获取文件上传时间并且格式化
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    createTime = sdf.format(new Date(file.lastModified()));
                } catch (IOException e) {
                    size = -1; // 如果文件写入失败，设置文件大小为-1
                    createTime = null; // 如果文件写入失败，设置上传时间为null
                    e.printStackTrace();
                }
                // 获取下载链接
                String link = "http://" + ip + ":" + port + contextPath + "/download?file=" + name;
                boolean insertInfo = kfmFileMapper.insertUploadFileInfo(name.substring(0, name.lastIndexOf(".")), size, createTime, uip,link);
                if (insertInfo) {
                    downloadLinks += "<a href='/download?file=" + name + "'>下载" + name.substring(0, name.lastIndexOf(".")) + "</a><br>";
                    message += "<p>" + name + "上传成功</p>";
                }

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
        resp.getWriter().write("<script>alert('上传成功'); window.location.href='"+req.getContextPath()+"/index';</script>");
    }
}

