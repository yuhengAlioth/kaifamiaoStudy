package Practice.LX0823;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0823
 * @文件名称：Login
 * @时间：2023/08/23/19:11
 */
public class Login {
    static Scanner input = new Scanner(System.in);
    static String username = "kfm";
    static String password = "123456";

    public static void main(String[] args) {
        // 系统默认的登录名和密码是  kfm/123456
        // 请在控制台开发一个登录界面，接受用户输入的登录名和密码，判断用户是否登录成功，
        // 登录成功后展示：“欢迎进入系统！”，即可停止程序。（最多三次登录机会）
        menu();
    }

    /**
     * 主菜单界面
     */
    private static void menu() {
        System.out.println("===========================");
        System.out.println("*********登录界面***********");
        System.out.println("1. 登录");
        System.out.println("0. 退出系统");
        System.out.println("===========================");
        System.out.print("请操作：");
        int type = input.nextInt();
        switch (type) {
            case 1 -> login();
            case 0 -> {
                return;
            }
        }
    }

    /**
     * 登录功能
     */
    private static void login() {
        int count = 3; // 登录次数
        for (int i = 3; i > 0; i--) {
            System.out.println();
            System.out.print("请输入用户名：");
            String us = input.next();
            System.out.print("请输入密码：");
            String pwd = input.next();
            if (!username.equals(us) || !password.equals(pwd)) {
                count--;
                if (count != 0) {
                    System.out.printf("用户名或密码错误，你还有%d次输入机会",count);
                } else {
                    System.out.print("今日机会已用完，明天来试！！！");
                    break;
                }
            } else {
                System.out.println("登陆成功");
                break;
            }
        }
    }

}

