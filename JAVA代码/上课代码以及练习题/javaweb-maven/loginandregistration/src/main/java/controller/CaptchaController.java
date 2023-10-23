package controller;

import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.ChineseGifCaptcha;
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
 * @包名：controller
 * @文件名称：CaptchaServlet
 * @代码功能：验证码服务
 * @时间：2023/10/21/9:50
 */


@WebServlet("/captcha")
public class CaptchaController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 中文类型
        ChineseCaptcha chineseCaptcha = new ChineseCaptcha(130, 48);
        // 中文gif类型
        ChineseGifCaptcha chineseGifCaptcha = new ChineseGifCaptcha(130, 48);
        // 使用gif验证码
        GifCaptcha gifCaptcha = new GifCaptcha(130,48,4);

        CaptchaUtil.out(gifCaptcha,request, response);
//        CaptchaUtil.out(chineseCaptcha,request, response);
//        CaptchaUtil.out(chineseGifCaptcha,request, response);
    }


}
