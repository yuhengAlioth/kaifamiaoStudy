package cn.aliothstar.servlet;

import cn.aliothstar.model.Users;
import cn.aliothstar.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.servlet
 * @文件名称：DeleteServlet
 * @代码功能：
 * @时间：2023/10/25/20:30
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private UsersService service = new UsersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int uid = Integer.parseInt(id);

        int delete = service.delete(uid);
        // 存储内容
        req.setAttribute("delete", delete);
        resp.sendRedirect("/all");

    }
}

