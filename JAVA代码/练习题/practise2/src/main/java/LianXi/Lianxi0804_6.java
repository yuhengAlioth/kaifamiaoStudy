package LianXi;

import java.util.Scanner;

public class Lianxi0804_6 {
    public static void main(String[] args) {
//        计算 n 的阶乘
//      5! = 5 * 4 * 3 * 2 * 1 输入一个数，计算阶乘
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数");
        int n = input.nextInt();
        int num = 1;
        for (int i = 1;i < n + 1;i ++){
            num *= i;
        }
        System.out.println(n + " 的阶乘是 " + num);
    }
}
