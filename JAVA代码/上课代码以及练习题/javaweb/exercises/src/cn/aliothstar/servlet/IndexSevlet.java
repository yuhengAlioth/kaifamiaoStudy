package cn.aliothstar.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：IndexSevlet
 * @代码功能：首页
 * @时间：2023/10/17/17:23
 */
@WebServlet("/index")
public class IndexSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 显示静态页面
        req.getRequestDispatcher("/index.html").forward(req,resp);
    }
}

