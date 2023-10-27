package cn.aliothstar.javaspring.utils;

/**
 * @作者：玉蘅
 * @项目名称：java-spring
 * @包名：cn.aliothstar.javaspring.utils
 * @文件名称：ValidUtils
 * @代码功能：注册验证
 * @时间：2023/10/27/11:38
 */

public class ValidUtils {

    /**
     * 校验邮箱是否合法
     *
     * @param email 输入的邮箱信息
     * @return 是否合法信息
     */
    public static boolean validEmail(String email) {
        String pattern = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        return email.matches(pattern);
    }

    /**
     * 校验密码强度 密码(以字母开头，长度在6~18之间，只能包含字母、数字和下划线)
     *
     * @param password 输入的密码信息
     * @return 是否强密码
     */
    public static boolean validPassword(String password) {
        String pattern = "^[a-zA-Z]\\w{5,17}$";
        return password.matches(pattern);
    }

    /**
     * 校验账号是否是否合法 帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)
     *
     * @param username 输入的用户名
     * @return 用户名是否合法
     */
    public static boolean validUsername(String username) {
        String pattern = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";
        return username.matches(pattern);
    }
}

