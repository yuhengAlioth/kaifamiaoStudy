package Practise03;

import java.util.Random;
import java.util.Scanner;

public class Lianxi0803_3 {
    public static void main(String[] args) {
        // 随机生成一个1-10之间的数据，提示用户猜测，猜大提示过大，猜小提示过小，直到猜中 结束游戏
        // 生成一个1-100 的数字Random rand = new Random(); int number = rand.nextInt(100) + 1 [, 99] [1, 100)
        // 获取输入对象
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int num = rand.nextInt(100) + 1; // 生成一个1-100 的数字
        System.out.println("已经随机生成1-100之间的一个数字,请输入你猜测的这个数");
//        System.out.println(num);
        while (true){
            int nums = input.nextInt();
            if ( nums > num){
                System.out.println("猜大了,请继续");
            }else if ( nums < num ){
                System.out.println("猜小了,请继续");
            } else {
                System.out.println("猜对了");
                break;
            }
        }
    }
}
