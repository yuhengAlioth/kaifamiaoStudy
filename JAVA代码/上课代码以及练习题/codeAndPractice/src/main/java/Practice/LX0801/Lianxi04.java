package Practice.LX0801;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0801
 * @文件名称：Lianxi04
 * @时间：2023/08/12/18:20
 */
public class Lianxi04 {
    public static void main(String[] args) {
        // 定义两个整变量，交换两个变量的值。 方法1：通过位运算(异或运算) 方法2：定义临时(中间)变量
        Scanner input = new Scanner(System.in);
        System.out.println("输入数字a：");
        int a = input.nextInt();
        System.out.println("输入数字b：");
        int b = input.nextInt();
        int c = b;
        b = a;
        a = c;
        System.out.println("交换变量之后：a = " + a + ",b = " + b );
    }
}

