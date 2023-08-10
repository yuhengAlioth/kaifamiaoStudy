package Practise08;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：practise2
 * @包名：Practise08
 * @文件名称：Lianxi0810_10
 * @时间：2023/08/10/20:25
 */
public class Lianxi0810_10 {
    public static void main(String[] args) {
        // 编写一个Jva程序，使用循环实现一个简单的登陆验证系统。
        // 系统预先设置一个用户名和密码，用户最多有3次输入机会。
        // 如果输入的用户名和密码与预设值匹配，则输出“登陆成功”，否则提示剩余尝试次数。
        Scanner input = new Scanner(System.in);
        String user = "admin";
        int password = 123456;
        int count = 3;

        for (int i = 3; i > 0; i--) {
            System.out.print("请输入用户名：");
            String us = input.next();
            System.out.print("请输入密码：");
            int pwd = input.nextInt();
            if (user.equals(us) == false || password != pwd) {
                count--;
                if (count != 0){
                    System.out.println("用户名错误，" + "还有" + count + "次输入机会");
                }else {
                    System.out.println("3次机会已用完");
                }
            }  else {
                System.out.println("登陆成功");
                break;
            }
        }
    }
}

