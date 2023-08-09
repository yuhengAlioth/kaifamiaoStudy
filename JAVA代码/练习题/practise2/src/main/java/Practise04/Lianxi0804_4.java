package Practise04;

import java.util.Scanner;

public class Lianxi0804_4 {
    public static void main(String[] args) {
//        洪乞丐干10天，收入是多少？
//        天朝有一个乞丐姓洪，去天桥要钱
//                第一天要了1块钱
//                第二天要了2块钱
//                第三天要了4块钱
//                第四天要了8块钱
//
        Scanner input = new Scanner(System.in);
        System.out.println("请输入天数");
        int day = input.nextInt();
        int money = 1; // 第一天的钱
        int n = 1;
        // 开始循环
        for (int i = 1;i < day;i ++){
            n *= 2; // 当天赚的钱
            money += n; //总钱数
        }
        System.out.println("洪乞丐 " + day + " 天,收入了 " + money + "元");
    }
}
