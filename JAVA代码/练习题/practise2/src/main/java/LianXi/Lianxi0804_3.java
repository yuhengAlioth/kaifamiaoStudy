package LianXi;

import java.util.Scanner;

public class Lianxi0804_3 {
    public static void main(String[] args) {
//        接收用户输入的数字,判断在此范围内质数的个数，例如输入90，输出0-90以内的所有质数的数量
        Scanner input = new Scanner(System.in);
        System.out.println("请输入求质数个数的范围");
        int num = input.nextInt();
        int g = 0;
        outer : for (int i = 1; i <= num; i ++) {
            int count = 0; // 统计能整除的数量
            for (int j = 1; j <= i; j ++) {
                // 从1到i的判断整除的组数
                if (i % j == 0) {
                    count ++;
                }
                // 大于2组跳出本次循环
                if (count > 2) {
                    continue outer;
                }
            }
            if (count == 2) {
                g += 1;
            }
        }
        System.out.println(num + "以内质数为：" + g + "个");
    }
}
