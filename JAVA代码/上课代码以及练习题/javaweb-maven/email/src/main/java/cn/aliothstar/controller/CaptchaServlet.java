package cn.aliothstar.controller;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.utils.CaptchaUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.controller
 * @文件名称：CaptchaServlet
 * @代码功能：
 * @时间：2023/10/20/22:35
 */

@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GifCaptcha gifCaptcha = new GifCaptcha();
        CaptchaUtil.out(gifCaptcha, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

