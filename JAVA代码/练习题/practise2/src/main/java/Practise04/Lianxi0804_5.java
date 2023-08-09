package Practise04;

import java.util.Scanner;

public class Lianxi0804_5 {
    public static void main(String[] args) {
//        李四跑步
//        李四每天跑步,第一周周一跑 100 米，周二到周天每天比前一天多 100 米。
//        往后每周一比前一周周一多 100 米。请问 李四 n（控制台输入） 天后跑了多少米
        Scanner input = new Scanner(System.in);
        System.out.println("请输入跑步天数");
        int n = input.nextInt();
        // 1. 处理整周
        // 2. 处理单个天数 n % 7
        int week = n / 7;   // 完整周
        int sum = 0;   // 总距离
        int monday = 0;   // 周一的距离
        for (int i = 0; i < week; i ++) {
            monday = monday + 100; // 每周周一的距离是上周周一的距离 + 100
            int day = monday;
            for (int j = 1; j <= 7; j++) { // 计算一周的总距离
                sum += day;
                day += 100;
            }
        }
        monday = monday + 100;
        int day = monday;
        for (int i = 0; i < n % 7; i ++) { // 计算 n % 7 天的总距离
            sum += day;
            day +=100;
        }
        System.out.println( n + " 天，总共跑了 " + sum + "米");
    }
}
