package Practise02;

import java.util.Scanner;

public class Lianxi0802_5 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("请输入员工的工龄");
        int num = input.nextInt();
        System.out.println("请输入员工的工资");
        double gz = input.nextDouble();
        double res = 0;
        if (num >= 0 && num <= 5){
            res = gz * 0.05 * 12;
        }else if (num > 5 && num <=10){
            res = gz * 0.1 * 12;
        }else if (num > 10){
            res = gz * 0.15 * 12;
        }
        System.out.println("该员工年终奖为：" + res + "元");

    }
}
