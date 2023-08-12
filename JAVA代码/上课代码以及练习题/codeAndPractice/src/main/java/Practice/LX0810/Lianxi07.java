package Practice.LX0810;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0810
 * @文件名称：Lianxi07
 * @时间：2023/08/12/18:50
 */
public class Lianxi07 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print("请输入一个四位数：");
        int num = input.nextInt();
        // 使用方法
        boolean status =  isPalindromeNumber(num);
        if (status == true){
            System.out.print(num + " 是回文数");
        }else {
            System.out.println(num + " 不回文数");
        }
    }
    //  编写一个方法 isPalindromeNumber(int number)，
    //  该方法接收一个四位整数参数 number，判断该数是否是回文数。
    //  回文数是指正序和倒序读都相同的整数。如果是回文数，则返回 true，否则返回false。
    public static boolean isPalindromeNumber(int number){
        int a = number / 1000;
        int b = number / 100 % 10;
        int c = number / 10 % 10;
        int d = number % 10;
        boolean status = false;
        if (a == d && b == c){
            status = true;
        }
        return status;
    }
}

