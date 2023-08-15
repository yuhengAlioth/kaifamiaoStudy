package Practice.LX0811;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0811
 * @文件名称：Lianxi08
 * @时间：2023/08/14/16:44
 */
public class Lianxi08 {
    public static void main(String[] args) {
        // 编写一个方法，接受一个数字 找出这个数字的所有质因数  15 = 3 * 5

        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个数字: ");
        int number = input.nextInt();
        System.out.print(number + " 的质因数为：");
        int zhiyingshu = 2;
        while (zhiyingshu <= number) {
            // 判断因数
            if (number % zhiyingshu == 0) {
                number = number / zhiyingshu;
                System.out.print(zhiyingshu + "\t");
            }
            else {
                zhiyingshu ++;
            }
        }

    }
}

