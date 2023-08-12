package Practice.LX0802;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0802
 * @文件名称：Lianxi01
 * @时间：2023/08/12/18:21
 */
public class Lianxi01 {
    public static void main(String[] args) {
        // 编写一个简单的计算器程序，要求用户输入两个数和操作符（+、-、*、/），
        // 然后根据操作符进行相应的运算，并输出结果。如果输入的运算符不是有效的运算符，则输出"无效的运算符"。
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

