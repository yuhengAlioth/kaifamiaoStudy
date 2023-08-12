package Practice.LX0811;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0811
 * @文件名称：Lianxi04
 * @时间：2023/08/12/18:54
 */
public class Lianxi04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num = input.nextInt();
        boolean status = SuShu(num);
        if (status == true){
            System.out.print(num + " 是素数");
        }else {
            System.out.print(num + " 不是素数");
        }
    }
    // 判断素数
    //编写一个方法，接受一个整数作为参数，并判断它是否为素数（质数）
    public static boolean SuShu(int num){
        boolean status = false;
        other : for (int i = 1; i <= num; i++) {
            int count = 0;
            for (int j = 1; j <= i ; j++) {
                if (i % j == 0){
                    count ++;
                }
                if (count > 2){
                    status = false;
                    continue other;
                }
            }
            if( count == 2){
                status = true;
            }
        }
        return status;
    }
}

