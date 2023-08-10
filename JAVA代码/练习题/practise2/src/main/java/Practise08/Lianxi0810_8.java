package Practise08;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：practise2
 * @包名：Practise08
 * @文件名称：Lianxi0810_8
 * @时间：2023/08/10/19:51
 */
public class Lianxi0810_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入第一个数：");
        double num1 = input.nextDouble();
        System.out.print("请输入运算符：");
        String op = input.next();
        System.out.print("请输入第二个数：");
        double num2 = input.nextDouble();
        // 字符串需要使用equals()来判断是否相等
        if ("+".equals(op) || "-".equals(op) || "*".equals(op) || "/".equals(op)){
            double res = isCounter(num1, num2, op);
            System.out.println("计算结果为：" + res);
        }else {
            System.out.println("输入的运算符不合法");
        }
    }

    // 编写一个Java程序，实现一个简单的计算器。
    // 用户输入两个数字和一个操作符(如加法、减法、乘法或除法)，程序根据操作符进行相应的计算并输出结果。
    public static double isCounter(double num1, double num2, String op) {
        double res = 0;
        switch (op) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
            case "%":
                res = num1 % num2;
                break;
            default:
                System.out.println("运算符不合法的运算符");
        }
        return res;
    }
}

