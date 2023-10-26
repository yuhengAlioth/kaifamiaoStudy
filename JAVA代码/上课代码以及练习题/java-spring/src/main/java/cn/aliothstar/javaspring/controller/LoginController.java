package cn.aliothstar.javaspring.controller;


import cn.aliothstar.javaspring.model.Users;
import cn.aliothstar.javaspring.service.UsersService;
import cn.aliothstar.javaspring.utils.Constant;
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
public class LoginController {
    private UsersService usersService = new UsersService();

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
    public String login(HttpServletRequest request,HttpServletResponse response){
        return "login";
    }

    @PostMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response, String captcha, String username, String password, HttpSession session) {

        boolean ver = CaptchaUtil.ver(captcha, request);
        if (ver) {
            CaptchaUtil.clear(request);

            // 调用service处理登录业务 返回登录成功的用户对象
            Users login = usersService.login(username, password);


            if (login == null) {
                System.out.println("账户或密码错误/用户不存在");
                response.setHeader("content-type", "text/html;charset=utf-8");
                try {
                    response.getWriter().write("<script>alert('账户或密码错误/用户不存在'); window.location.href='/login';</script>");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                // 将登录的用户存储到session中
//                HttpSession session = request.getSession();
                session.setAttribute(Constant.LOGIN_USER_KEY, login);


                // 向前端响应登录成功页面
                response.setHeader("content-type", "text/html;charset=utf-8");
                //获取字符输出流将内容输出到浏览器
                try {
                    response.getWriter().write("<script>alert('登录成功'); window.location.href='/home';</script>");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            CaptchaUtil.clear(request);
            System.out.println("验证码错误");
            response.setHeader("content-type", "text/html;charset=utf-8");
            try {
                response.getWriter().write("<script>alert('验证码错误'); window.location.href='/login';</script>");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    @GetMapping("/home")
    public String home(HttpServletRequest request,HttpServletResponse response){
        return "home";
    }

}

