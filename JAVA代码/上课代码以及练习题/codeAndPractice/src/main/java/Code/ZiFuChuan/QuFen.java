package Code.ZiFuChuan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ZiFuChuan
 * @文件名称：QuFen
 * @时间：2023/08/23/15:57
 */
public class QuFen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("输入英文和数字的字符串：");
        String str = input.next();
        // 方法一
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
        int ziMu = 0;
        int shuZi = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] >= 65 && bytes[i] <= 122){
                ziMu++;
            }else if (bytes[i] >= 48 && bytes[i] <= 57){
                shuZi++;
            }
        }
        System.out.println("字母有：" + ziMu + "个");
        System.out.println("数字有：" + shuZi + "个");

        // 方法二
        int letterCount = 0;
        int numberCount = 0;
        char[] chars = str.toCharArray();
        System.out.println(Arrays.toString(chars));
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z' || (chars[i] >= 'A' && chars[i] <= 'Z')){
                letterCount++;
            }else if (chars[i] >= '0' && chars[i] <= '9'){
                numberCount++;
            }
        }
        System.out.printf("字母有：%d 个",letterCount);
        System.out.println();
        System.out.printf("数字有：%d 个",numberCount);
    }

}

