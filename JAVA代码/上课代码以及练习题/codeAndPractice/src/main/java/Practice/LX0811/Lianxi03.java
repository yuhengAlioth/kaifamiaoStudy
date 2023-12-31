package Practice.LX0811;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0811
 * @文件名称：Lianxi03
 * @时间：2023/08/12/18:54
 */
public class Lianxi03 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print("请输入一个数字：");
        int num = input.nextInt();
        int sum = JieCheng(num);
        System.out.print(num + " 的阶乘为：" + sum);
    }
    // 阶乘
    //编写一个方法，接受一个正整数作为参数，并返回它的阶乘
    public static int JieCheng(int num){
        if (num == 1 || num == 0){
            return  1;
        }
        return num * JieCheng(num - 1);
    }
}

