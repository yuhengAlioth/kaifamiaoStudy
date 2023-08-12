package Practice.LX0804;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0804
 * @文件名称：Lianxi07
 * @时间：2023/08/12/18:30
 */
public class Lianxi07 {
    public static void main(String[] args) {
        // 输入一个数字和位数，判断这个数是否回文数字 1221 就是回文数字
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数字：");
        int number = scanner.nextInt();
        System.out.print("请输入数字的位数：");
        int digits = scanner.nextInt();
        //  方法一
        // 判断是否是回文数字
        boolean isPalindrome = true;
        String str = String.valueOf(number);
        int length = str.length();
        if (length != digits) {
            isPalindrome = false;
        }
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                isPalindrome = false;
            }
        }
        if (isPalindrome) {
            System.out.println(number + " 是回文数字");
        } else {
            System.out.println(number + " 不是回文数字");
        }
    }
}

