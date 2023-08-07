package LianXi;

import java.util.Scanner;

public class LianXi0804_10 {
    public static void main(String[] args) {
        // 使用数组实现斐波拉切数列
        // 输入 n 输出前 n 个数 存储到数组 再输出
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个数字：");
        int number = sc.nextInt();
        int[] feibo = new int[number];
// int prev = 1; // 第一个值
// int next = 1; // 第二个值
// feibo[0] = prev;
// feibo[1] = next;
        if (number == 1) {
            feibo[0] = 1;
        } else if (number == 2) {
            feibo[0] = 1;
            feibo[1] = 1;
        } else {
// feibo : 1 1 2 3
            feibo[0] = 1;
            feibo[1] = 1; // 1 1 x
            for (int i = 3; i <= number; i++) { // i = 3 i = 4
                feibo[i - 1] = feibo[i - 3] + feibo[i - 2];
// int curr = prev + next;
// feibo[i - 1] = curr;
// prev = next;
// next = curr;
            }
        }
        for (int i = 0; i < feibo.length; i++) {
            System.out.print(feibo[i] + " ");
        }
    }
}
