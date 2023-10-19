package cn.aliothstar.servlet;

import cn.aliothstar.utils.Constant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：UploadServlet
 * @代码功能：上传文件服务
 * @时间：2023/10/18/11:06
 */
@WebServlet("/upload")
@MultipartConfig(location = "E:\\TestScratchFile") // 当前的Servlet支持文件上传操作 location 默认指定上传的地址
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/upload.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置获取和返回的编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 处理文件上传的逻辑  将上传的文件封装到Part对象里面
        Part allFile = req.getPart("allFile");

//        // 获取上传的文件名称
//        String fileName = allFile.getSubmittedFileName();
//        System.out.println("上传的文件名称：" + fileName);
//
//        String oldFileName = fileName;
//        // 获取上传的时候定义的name属性的值 file
//        System.out.println("name:" + allFile.getName());
//
////        String dir = "E:\\TestUpload";
////        fileName = dir + File.separator + fileName;
//        fileName = Constant.UPLOAD_PATH + File.separator + fileName;
//
//        File file1 = new File(fileName);
//        if (!file1.getParentFile().exists()) {
//            file1.getParentFile().mkdirs();
//        }
//        System.out.println(fileName);
//
//        try {
//            allFile.write(fileName);
//            resp.getWriter().write("<h3>上传成功</h3>");
//            String downloadLink = "<a href=\"/exercises/download?file=" + oldFileName + "\" >下载图片</a>";
//            resp.getWriter().write("<h3>上传成功</h3>" + downloadLink);
//        } catch (IOException e) {
//            e.printStackTrace();
//            resp.getWriter().write("<h3>上传失败</h3>");
//        }
        String type = allFile.getContentType();// 获取上传文件的类型
        System.out.println("文件上传类型" + type);
        if (Constant.ALLOW_TYPES.contains(type)) { // 是否支持当前上传的文件类型
            // 获取上传的文件名称
            String fileName = allFile.getSubmittedFileName();
            String name = fileName;
            // System.out.println("上传的文件名称：" + fileName);
            // 获取上传的时候定义的name属性的值 file
            // System.out.println("name:" + file.getName());
            fileName = Constant.UPLOAD_PATH + File.separator + fileName;
            File file1 = new File(fileName);
            if (!file1.getParentFile().exists()) {
                file1.getParentFile().mkdirs();
            }
            System.out.println(fileName);
            // D:\\temp\\temp.txt
            // E:\\temp\\xxx.jpg
            try {
                allFile.write(fileName);
                String downloadLink = "<a href=\"/exercises/download?file=" + name + "\" >下载图片</a>";
                resp.getWriter().write("<h3>上传成功</h3>" + downloadLink);
            } catch (IOException e) {
                e.printStackTrace();
                resp.getWriter().write("<h3>上传失败</h3>");
            }
        } else {
            resp.getWriter().write("<h3>上传文件格式不支持</h3>");
        }
    }
}

