package cn.aliothstar.javaspring.controller;


import cn.aliothstar.javaspring.model.Users;
import cn.aliothstar.javaspring.service.UsersService;
import cn.aliothstar.javaspring.utils.Constant;
import cn.aliothstar.javaspring.utils.ValidUtils;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.ChineseGifCaptcha;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @作者：玉蘅
 * @项目名称：java-spring
 * @包名：cn.aliothstar.javaspring.controller
 * @文件名称：LoginController
 * @代码功能：登录
 * @时间：2023/10/26/17:11
 */
@Controller
public class UsersController {
    private UsersService usersService = new UsersService();

    /**
     * 验证码处理
     * @param request 获取请求
     * @param response 返回结果
     */
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        // 中文类型
        ChineseCaptcha chineseCaptcha = new ChineseCaptcha(130, 48);
        // 中文gif类型
        ChineseGifCaptcha chineseGifCaptcha = new ChineseGifCaptcha(130, 48);
        // 使用gif验证码
        GifCaptcha gifCaptcha = new GifCaptcha(130, 48, 4);

        try {
            CaptchaUtil.out(gifCaptcha, request, response);
//            CaptchaUtil.out(chineseCaptcha,request, response);
//            CaptchaUtil.out(chineseGifCaptcha,request, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 登录处理
     * @param request 获取请求
     * @param response 返回结果
     * @param captcha 接收客户端输入的验证码
     * @param username 接收客户端输入的用户名
     * @param password 接收客户端输入的密码
     * @param session session域
     * @return 跳转页面
     */
    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, String captcha, String username, String password, HttpSession session) {

        boolean ver = CaptchaUtil.ver(captcha, request);
        if (!ver) {
            CaptchaUtil.clear(request);
            session.setAttribute(Constant.MESSAGE_KEY, "验证码错误！！！");
            return "login";
        }

        CaptchaUtil.clear(request);
        // 调用service处理登录业务 返回登录成功的用户对象
        Users login = usersService.login(username, password);

        if (login == null) {
            session.setAttribute(Constant.MESSAGE_KEY,"登录失败");
            return "login";
        }
        session.setAttribute(Constant.LOGIN_USER_KEY, login);
        session.setAttribute(Constant.MESSAGE_KEY,"登录成功！");
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @PostMapping("/register")
    public String register(String username, String password, String confirmPassword, String captcha, String email, HttpServletRequest request, HttpSession session) {
//        boolean ver = CaptchaUtil.ver(captcha, request);
//        if (!ver) {
//            CaptchaUtil.clear(request);
//            session.setAttribute(Constant.MESSAGE_KEY, "验证码错误！");
//            return "register";
//        }
//        CaptchaUtil.clear(request);

        if (password == null || !password.equals(confirmPassword)) {
            session.setAttribute("msg", "密码不一致");
            return "register";
        }

        // username长度必须在5位以上 不能有中文不能以数字开头
        if (!ValidUtils.validUsername(username)) {
            session.setAttribute("msg", "用户名不规范，字母开头，允许5-16字节，允许字母数字下划线");
            return "register";
        }

        // 校验email
        if (!ValidUtils.validEmail(email)) {
            session.setAttribute("msg", "邮箱地址不正确");
            return "register";
        }
        // 密码强度校验
        if (!ValidUtils.validPassword(password)) {
            session.setAttribute("msg", "以字母开头，长度在6~18之间，只能包含字母、数字和下划线");
            return "register";
        }

        int rows = usersService.register(username, password, email);
        if (rows > 0) {
            session.setAttribute("msg", "注册成功，请登录");
            return "redirect:/login";
        }
        session.setAttribute("msg", "注册失败，请重新注册");
        return "register";
    }
}

