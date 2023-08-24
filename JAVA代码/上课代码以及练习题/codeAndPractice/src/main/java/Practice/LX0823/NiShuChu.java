package Practice.LX0823;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0823
 * @文件名称：NiShuChu
 * @时间：2023/08/23/20:53
 */
public class NiShuChu {
    public static void main(String[] args) {
        // 将一个字符串逆序输出
        Scanner input = new Scanner(System.in);
        System.out.print("输入字符串：");
        String a = input.next();
        niXu(a);
    }
    private static void niXu(String str){
        String newStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
                newStr += str.charAt(i);
        }
        System.out.println(newStr);
    }
}

