package Practise02;

import java.util.Scanner;

public class Lianxi0802_1 {
    public static void main(String[] args) {
//    编写一个简单的计算器程序，要求用户输入两个数和操作符（+、-、*、/），
//    然后根据操作符进行相应的运算，并输出结果。如果输入的运算符不是有效的运算符，则输出"无效的运算符"。
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个数");
        double num1 = input.nextDouble();
        System.out.println("请输入第二个数");
        double num2 = input.nextDouble();
        System.out.println("请输入运算符");
        String op = input.next();
        double res = 0;
        boolean flag = true;
        switch (op){
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
                flag = false;
                System.out.println("不合法的运算符");
        }
        if (flag){
            System.out.println("计算结果为：" + res);
        }
    }
}
