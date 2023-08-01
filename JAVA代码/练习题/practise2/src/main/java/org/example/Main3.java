package org.example;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        // 编写一个Java程序，接收用户输入的一个三角形的三个边长，判断这三条边是否能构成一个三角形，并输出相应的结果。
        Scanner input = new Scanner(System.in);
        System.out.println("请输入三角形的第一条边");
        int a = input.nextInt();
        System.out.println("请输入三角形的第二条边");
        int b = input.nextInt();
        System.out.println("请输入三角形的第三条边");
        int c = input.nextInt();
        boolean res = ((a + b) > c && (a + c) > b && (b + c) > a) || (((a + b) > c && (a + c) > b && (b + c) > a) &&
                ((a - b) < c && (a - c) < b && (b - c) < a));
        System.out.println("输入的三条边是否是三角形：" + res);
    }
}
