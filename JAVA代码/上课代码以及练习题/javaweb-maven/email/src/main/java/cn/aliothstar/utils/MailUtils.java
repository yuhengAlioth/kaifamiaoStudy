package cn.aliothstar.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

import java.util.Random;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.utils
 * @文件名称：MailUtils
 * @代码功能：邮件工具类
 * @时间：2023/10/20/17:35
 */

public class MailUtils {
    public static String sendEmail(String email) {
        MailAccount account = new MailAccount();
        // 邮件的服务器
        account.setHost("smtp.qq.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("1300343646@qq.com");
        account.setUser("1300343646@qq.com");
        account.setPass("*****");
        String code = randomCode(6);
        MailUtil.send(account, CollUtil.newArrayList(email), "验证码", code, false);
        System.out.println("邮件发送成功！");
        return code;
    }

    private static String randomCode(int number) {
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }
}

