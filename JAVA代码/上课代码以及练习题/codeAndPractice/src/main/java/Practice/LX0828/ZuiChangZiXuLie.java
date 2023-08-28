package Practice.LX0828;

import java.util.Arrays;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0828
 * @文件名称：ZuiChangZiXuLie
 * @代码功能：最长公共子序列
 * @时间：2023/08/28/20:23
 */
public class ZuiChangZiXuLie {
    public static void main(String[] args) {
        // 给定两个字符串，编写一个函数来获取这两个字符串的最长公共子序列。
        //> 例如：
        //> 输入 ： "abcde" "ace"
        //> 输出 ： "ace"
        //> 输入："abc"  "def"
        //> 输出：""
        //> 输入："AGGTAB" "GXTXAYB"
        //> 输出："GTAB"
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        System.out.println(check(str1, str2));
    }

    public static String check(String str1, String str2) {
        if (str1.length()>str2.length()){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        String str = "";
        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str1.length(); j++) {
                if (str2.charAt(i)==str1.charAt(j)) {
                    str += str2.charAt(i);
                    break;
                }
            }
        }
        StringBuffer str3 = new StringBuffer(str);
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if (currentChar == str.charAt(j)) {
                    str3.deleteCharAt(i);
                }
            }
        }
        str = str3.toString();
//        System.out.println(str2);
        return str;
    }
}

