package Practise01;

import java.util.Scanner;

public class Lianxi0801 {
    public static void main(String[] args) {
//  从键盘上输入一个四位整数，求各位数之和。
        System.out.println("请输入一个四位整数");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
//        拿到千位数的数字
        int a = num / 1000; // 获取千位数
        int b = (num - a * 1000) /100; // 获取百位数
        int c = (num - a * 1000 - b * 100) / 10; // 获取十位数
        int d = (num - a * 1000 - b * 100 - c *10); // 获取个位数
        int sum = a + b +c +d;
        System.out.println("千位数是：" + a + "\t百位数是：" + b + "\t十位数是：" + c + "\t个位数是：" + d);
        System.out.println("各位数之和为：" + sum);

    }
}