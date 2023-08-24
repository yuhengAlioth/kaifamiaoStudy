package Practice.LX0823;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0823
 * @文件名称：JieQu
 * @时间：2023/08/23/21:20
 */
public class JieQu {
    public static void main(String[] args) {
        // 定义一个用于截取文件后缀名的方法, 传入一个字符串的文件名( hello.java),返回一个字符串。
        Scanner input = new Scanner(System.in);
        System.out.print("请输入文件名全称：");
        String str = input.next();
        houZhui(str);
    }
    private static void houZhui(String str){
        System.out.println(str.lastIndexOf('.'));
        int lastIndex = str.lastIndexOf('.');
        System.out.println(str.substring(0, lastIndex));
    }
}

