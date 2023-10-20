package cn.aliothstar.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：GetSessionServlet
 * @代码功能：获取session
 * @时间：2023/10/20/11:23
 */

@WebServlet("/getSession")
public class GetSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Session对象
        HttpSession session = req.getSession();
        System.out.println(session);
        // 获取Session对象存储的共享数据 getAttribute(key)
        Object value = session.getAttribute("name");
        System.out.println(value);
        // 删除存储在Session中的指定数据
        session.removeAttribute("name");
        System.out.println("删除存储的name");
    }
}

