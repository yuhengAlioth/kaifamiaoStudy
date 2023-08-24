package Practice.LX0823;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0823
 * @文件名称：DuiCheng
 * @时间：2023/08/23/20:41
 */
public class DuiCheng {
    public static void main(String[] args) {
        // 请定义一个方法用于判断一个字符串是否是对称的字符串，并在主方法中测试方法。
        Scanner input = new Scanner(System.in);
        System.out.print("输入一组字符：");
        String str = input.next();
        if (duiCheng(str)){
            System.out.println(str + " 是对称字符串");
        }else {
            System.out.println(str + " 不是对称字符串");
        }
    }
    private static boolean duiCheng(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }

}

