package Practice.LX0810;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0810
 * @文件名称：Lianxi05
 * @时间：2023/08/12/18:49
 */
public class Lianxi05 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print("请输入一个数：");
        int num = input.nextInt();
        // 使用方法
        boolean status =  isInValidRange(num);
        if (status == true){
            System.out.print(num + " 在有效范围内");
        }else {
            System.out.println(num + " 不在有效范围内(0 <= num <= 100)");
        }
    }
    // 编写一个方法 isInValidRange(int number)，
    // 该方法接收一个整数参数number，判断该数是否在有效范围内。有效范围定义为大于等于 0 且小于等于 100。
    // 如果在有效范围内，则返回 true，否则返回 false。
    public static boolean isInValidRange(int number){
        boolean status = false;
        if (number >= 0 && number <= 100){
            status = true;
        }
        return status;
    }
}

