package com.kfm.first.controller;

import com.kfm.first.dao.StudentsDao;
import com.kfm.first.entity.Page;
import com.kfm.first.entity.Students;
import com.kfm.first.service.UserService;
import com.yufeixuan.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    private static StudentsDao studentsDao = new StudentsDao();
    private UserService userService = new UserService();

    @GetMapping("/index")
    public String index() {
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login")
    public String test(HttpServletRequest request, HttpServletResponse response, String username, String password, String captcha) throws IOException {
        Students user = studentsDao.login(username, password);
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("type/html;charset=utf-8");
        boolean ver = CaptchaUtil.ver(captcha, request);
        if (!ver) {
            String html = "<script>alert('验证码错误'); window.location.href='/login';</script>";
            CaptchaUtil.clear(request);
            response.getWriter().write(html);
        }
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginuser", user);
            return "index";
        } else {
            String html = "<script>alert('用户名或密码错误');</script>";
            return "login";
        }
    }



    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request, HttpServletResponse response){
        List<Students> userEntities = studentsDao.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("users", userEntities);
        return "findall";
    }
    @RequestMapping("/fAll")
    public String fAll(HttpServletRequest request, HttpServletResponse response,int page, int pageSize){
        List<Students> userEntities = studentsDao.selectAll(page,pageSize);
        HttpSession session = request.getSession();
        session.setAttribute("user", userEntities);
        return "fAll";
    }
    @RequestMapping("/listPage")
    public ModelAndView getPage(Integer pageNum, Integer pageSize){
        Page<Students> page = userService.findPage(pageNum,pageSize);
        ModelAndView mv =new ModelAndView();
        mv.addObject("page",page);
        mv.setViewName("findalls");
        return mv;
    }
    @GetMapping("/deleteuser")
    public String deleteUser(HttpServletRequest request, int id, Model model) {
        int delete = studentsDao.delete(id);
        if (delete > 0) {
            model.addAttribute("message", "删除成功");
        } else {
            model.addAttribute("message", "删除失败");
        }
        return "redirect:/findAll";
    }

    @RequestMapping("/showOne")
    public String showOne(int id,Model model){
        Students user = studentsDao.selectOne(id);
        model.addAttribute("oneUser",user);
        return "modify";
    }
    @RequestMapping("/modify")
    public String modify(HttpServletResponse response,Model model,String username,String password,String name,int age,int id){
        int modify = studentsDao.modify(username, password, name, age, id);
        if (modify > 0) {
            model.addAttribute("msg", "修改成功");
        } else {
            model.addAttribute("message", "修改失败");
        }
        return "redirect:/findAll";
    }
    @GetMapping("/adduser")
    public String jumpAddUser(){
        return "adduser";
    }
    @RequestMapping("/adduser")
    public String add(Model model,String username,String password,String name,int age){
        int i = studentsDao.addUser(username, password, name, age);
        if (i >0){
            model.addAttribute("msg","添加成功");
        } else {
            model.addAttribute("msg","添加失败");
        }
        return "redirect:/findAll";
    }
}
