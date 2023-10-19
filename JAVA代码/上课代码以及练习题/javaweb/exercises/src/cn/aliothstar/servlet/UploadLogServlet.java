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
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：UploadLogServlet
 * @代码功能：
 * @时间：2023/10/18/20:20
 */
@WebServlet("/uploadLog")
@MultipartConfig
public class UploadLogServlet extends HttpServlet {
    private UploadLogDao uploadLogDao = new UploadLogDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

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
                long fileSize = -1;
                // 文件上传时间，初始设为 null
                String fileUploadTime = "";
                // 格式化后的文件大小
                String size = "";

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
                    fileSize = file.length();
                    size = String.valueOf(fileSize) + " B";
                    // 获取文件上传时间并且格式化
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    fileUploadTime = sdf.format(new Date(file.lastModified()));
                } catch (IOException e) {
                    fileSize = -1; // 如果文件写入失败，设置文件大小为-1
                    fileUploadTime = null; // 如果文件写入失败，设置上传时间为null
                    e.printStackTrace();
                }
                // 获取下载链接
                String link = "http://" + ip + ":" + port + contextPath + "/download?file=" + name;
                boolean insertInfo = uploadLogDao.insertInfo(uip, port, name.substring(0, name.lastIndexOf(".")), type, size, fileUploadTime, link);
                if (insertInfo) {
                    downloadLinks += "<a href='/exercises/download?file=" + name + "'>下载" + name.substring(0, name.lastIndexOf(".")) + "</a><br>";
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


    }
}

