package LianXi;

import java.util.Scanner;

public class Lianxi0804_7 {
    public static void main(String[] args) {
//        输入一个数字和位数，判断这个数是否回文数字 1221 就是回文数字
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数字：");
        int number = scanner.nextInt();
        System.out.print("请输入数字的位数：");
        int digits = scanner.nextInt();
        boolean isPalindrome = checkPalindrome(number, digits);
        if (isPalindrome) {
            System.out.println(number + " 是回文数字");
        } else {
            System.out.println(number + " 不是回文数字");
        }
    }
    public static boolean checkPalindrome(int number, int digits) {
        String str = String.valueOf(number);
        int length = str.length();
        if (length != digits) {
            return false;
        }
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
