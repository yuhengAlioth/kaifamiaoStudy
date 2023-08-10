package Practise04;

import java.util.Scanner;

public class Lianxi0804_1 {
    public static void main(String[] args) {
//        求指定两个数的最大公约数和最小公倍数
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数");
        int a = input.nextInt();
        System.out.println("请输入另外一个数");
        int b = input.nextInt();
        int yue = 0;
        int bei;
        for (int i = 1; i <= b; i++) {
            if (b % i == 0 && a % i == 0) {
                yue = i;
            }
        }
        bei = ( a * b ) / yue;
        System.out.println("最大公约数为：" + yue);
        System.out.println("最小公倍数：" + bei);
    }
}
