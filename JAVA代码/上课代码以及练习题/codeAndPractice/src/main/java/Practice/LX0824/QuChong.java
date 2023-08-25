package Practice.LX0824;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0824
 * @文件名称：QuChong
 * @时间：2023/08/24/21:11
 */
public class QuChong {

    public static void main(String[] args) {
        // 去除重复字符
        //编写一个程序，去除字符串中的重复字符。
        //例如：输入 asdfgnasd ，输出 asdfgn
        String str = "asdfgnasd";
        System.out.print("原来的字符串为：" + str);
        char[] charArray = str.toCharArray();
        int k = charArray.length - 1;
        for (int i = 0; i < k; i++) {
            if (charArray[k] == charArray[i]) k--;
            for (int j = i + 1; j <= k ; j++) {
                if (charArray[i] == charArray[j]){
                    char temp = charArray[j];
                    charArray[j] = charArray[k];
                    charArray[k] = temp;
                    k--;
                }
            }
        }
        System.out.println();
        System.out.print("去重的字符串为：");
        for (int i = 0; i <= k + 1; i++) {
            System.out.print(charArray[i]);
        }



        System.out.println();
        System.out.println("============================");
        Scanner input = new Scanner(System.in);
        System.out.print("输入一串字符：");
        String string = input.next();
        String letter = quChong(string);
        System.out.println(letter);
    }
    public static String quChong(String str){
        // 将空格替换为空字符串
        str = str.replace(" ","");
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            // 将字符串拆成字符
            char c = str.charAt(i);
            if (newStr.indexOf(c) == -1){ // 如果新字符串中没有就添加进去
                newStr += c;
            }
        }
        return newStr;
    }
}

