package controller;

import model.KfmUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：controller
 * @文件名称：IndexController
 * @代码功能：
 * @时间：2023/10/21/16:41
 */
@WebServlet("/index")
public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.html").forward(req,resp);

//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=utf-8");
//        HttpSession session = req.getSession();
//        Object loginUser = session.getAttribute("loginUser");
//        System.out.println(loginUser);
//
//        String name = ((KfmUser) loginUser).getName();



    }
}

