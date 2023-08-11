package Practise09;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：practise2
 * @包名：Practise09
 * @文件名称：Lianxi0811_6
 * @时间：2023/08/11/20:14
 */
public class Lianxi0811_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数字：");
        int num = scanner.nextInt();
        System.out.print("请输入数字的位数：");
        int key = scanner.nextInt();
        boolean status = HuiWen(num,key);
        if (status) {
            System.out.println(num + " 是回文数字");
        } else {
            System.out.println(num + " 不是回文数字");
        }
    }
    // 回文数
    //编写一个方法，接受一个整数作为参数，判断它是否为回文数（正着读和倒着读都一样）
    public static boolean HuiWen(int num,int key){
        boolean status = true;
        // 将数字变为字符串
        String str = String.valueOf(num);
        // 获取字符串长度
        int length = str.length();
        if (length != key) {
            status = false;
        }
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                status = false;
            }
        }
        return status;
    }
}

