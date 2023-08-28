package Practice.LX0828;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0828
 * @文件名称：PiPeiKuoHao
 * @代码功能：匹配括号
 * @时间：2023/08/29/0:44
 */
public class PiPeiKuoHao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个包含括号的字符串：");
        String str = sc.next();
        System.out.println(isValid(str));
    }

    public static boolean isValid(String str) {
        char[] arr = new char[str.length()];
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                arr[count++] = c;
            } else if (c == ')' || c == ']' || c == '}') {
                if (count == 0) {
                    return false;
                }
                char top = arr[--count];
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return count == 0;
    }

}

