package Practice.LX0811;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0811
 * @文件名称：Lianxi02
 * @时间：2023/08/12/18:53
 */
public class Lianxi02 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num1 = input.nextInt();
        System.out.print("请输入一个整数：");
        int num2 = input.nextInt();
        int sum = QiuHe(num1,num2);
        System.out.print(num1 + " + " + num2 + " = " + sum);
    }
    // 求和
    // 设计一个方法，用于计算整数的和
    public static int QiuHe(int num1,int num2){
        int sum = num1 + num2;
        return sum;
    }
}

