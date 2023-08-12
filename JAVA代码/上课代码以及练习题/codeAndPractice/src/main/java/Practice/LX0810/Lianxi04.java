package Practice.LX0810;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0810
 * @文件名称：Lianxi04
 * @时间：2023/08/12/18:48
 */
public class Lianxi04 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print("请输入一个数：");
        double num = input.nextDouble();
        // 使用方法
        boolean status =  isPositiveAndGreaterThanTen(num);
        if (status == true){
            System.out.print(num + " 是正数且大于 10");
        }else {
            System.out.println(num + " 不满足是正数且大于 10");
        }
    }
    // 编写一个方法 isPositiveAndGreaterThanTen(double number)，
    // 该方法接收一个双精度浮点数参数 number，判断该数是否是正数且大于 10。如果满足条件，则返回 true，否则返回 false。
    public static boolean isPositiveAndGreaterThanTen(double number){
        boolean status = false;
        if (number > 0 && number > 10){
            status = true;
        }
        return status;
    }
}

