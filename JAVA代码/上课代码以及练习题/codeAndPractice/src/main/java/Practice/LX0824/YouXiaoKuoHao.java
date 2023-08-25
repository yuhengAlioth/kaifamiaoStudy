package Practice.LX0824;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0824
 * @文件名称：YouXiaoKuoHao
 * @时间：2023/08/24/21:12
 */
public class YouXiaoKuoHao {
    public static void main(String[] args) {
        // 有效括号
        //给定一个只包括 ‘(‘，’)’ 的字符串，判断字符串是否有效。
        //有效字符串需满足：
        //1.左括号必须⽤相同类型的右括号闭合。
        //2.左括号必须以正确的顺序闭合。
        //3.注意空字符串可被认为是有效字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个包含括号的字符串：");
        String str = sc.next();
        System.out.println(isValid3(str));
    }


    public static boolean isValid3(String str) { // (((()))
        // 栈 先进后出
        char[] chars = new char[str.length()]; // ( ( '('
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                chars[count++] = c;
            } else if (c == ')') {
                if (count == 0) {
                    return false;
                }
                if (chars[count - 1] == '(') {
                    chars[--count] = ' ';
                }
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }

}

