package Practice.LX0801;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0801
 * @文件名称：Lianxi02
 * @时间：2023/08/12/18:19
 */
public class Lianxi02 {
    public static void main(String[] args) {
        // 从键盘上输入一个三位数，判断是否是水仙花数，是输出true，
        // 不是输出false 水仙花：各个位上的数字的立方和等于该数本身
        System.out.println("输入一个三位数");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int a = num / 100; // 获取百位数
        int b = num / 10 % 10; // 获取十位数
        int c = num % 10; // 获取个位数
        boolean res = (a*a*a + b*b*b + c*c*c) == num ? true : false;
        System.out.println("输入的数字是否是水仙花数：" + res);
    }
}

