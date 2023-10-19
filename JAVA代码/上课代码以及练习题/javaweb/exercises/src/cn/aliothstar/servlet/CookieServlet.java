package cn.aliothstar.servlet;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Random;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.servlet
 * @文件名称：CookieServlet
 * @代码功能：设置Cookie
 * @时间：2023/10/19/16:49
 */
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 生成随机数
        String randomNumber = generateRandomNumber();
        // 收件人邮箱
        String toEmail = "201389626@qq.com";
        // 发件人邮箱
        String fromEmail = "1532250426@qq.com";
        // 发件人邮箱密码
        String password = "msaqkdmvahhqhfib";
        // 发送邮件
        sendEmail(toEmail, fromEmail, password, randomNumber);

        Cookie cookie = new Cookie(URLEncoder.encode("randomNumber", StandardCharsets.UTF_8), URLEncoder.encode(randomNumber, StandardCharsets.UTF_8));
        // 设置 Cookie 的存活时间 就将Cookie存储到浏览器所在的硬盘里 到期自动删除
        cookie.setMaxAge(60 * 60 * 24 * 7);
        resp.addCookie(cookie);
    }

    // 生成六位数随机数
    private String generateRandomNumber(){
        Random random = new Random();
        int num = random.nextInt(900000) + 100000;  // 生成 100000-999999 的随机数
        return String.valueOf(num);
    }

    // 使用 JavaMail API 发送邮件
    private void sendEmail(String toEmail, String fromEmail, String password, String randomNumber) {
        final String username = fromEmail;
        final String passwordd = password;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", "smtp.qq.com");
        props.put("mail.smtp.port", "465");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("你的验证码");
            message.setText("验证码: " + randomNumber);
            // 发送消息
            Transport.send(message);
            System.out.println("验证码发送成功...");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
