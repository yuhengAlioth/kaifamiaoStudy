package Practice.LX0810;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0810
 * @文件名称：Lianxi03
 * @时间：2023/08/12/18:48
 */
public class Lianxi03 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print("请输入一个数：");
        int num = input.nextInt();
        // 使用方法
        boolean status =  isEvenAndDivisibleByThree(num);
        if (status == true){
            System.out.print(num + " 是偶数又能被3整除");
        }else {
            System.out.println(num + " 不满足是偶数又能被3整除的条件");
        }
    }
    // 编写一个方法 isEvenAndDivisibleByThree(int number)，
    // 该方法接收一个整数参数 number，判断该数是否既是偶数又能被3整除。如果是，则返回 true，否则返回 false。
    public static boolean isEvenAndDivisibleByThree(int number) {
        boolean status = false;
        if (number % 2 == 0 && number % 3 == 0) {
            status = true;
        }
        return status;
    }
}

