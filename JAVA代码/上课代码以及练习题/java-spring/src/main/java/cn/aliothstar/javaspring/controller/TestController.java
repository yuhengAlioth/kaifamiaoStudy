package cn.aliothstar.javaspring.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：java-spring
 * @包名：cn.aliothstar.javaspring.controller
 * @文件名称：TestController
 * @代码功能：控制器
 * @时间：2023/10/26/11:40
 */
@Controller
public class TestController {
    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("你好 spring boot");
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().write("创建成功了");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/index")
    public String index() {
        // 逻辑视图名称
        return "index";
    }
    @PostMapping("/app")
    public void app(HttpServletRequest request,HttpServletResponse response){
        System.out.println("post请求");
    }
    @GetMapping("/app")
    public void app2(HttpServletRequest request,HttpServletResponse response){
        System.out.println("get请求");
    }
}

