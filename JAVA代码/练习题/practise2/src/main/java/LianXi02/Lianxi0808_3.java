package LianXi02;

import java.util.Scanner;

public class Lianxi0808_3 {
    public static void main(String[] args) {
        // 第n大数,给定一个整数数组，输入一个值 n, 输出数组中第 n 大的数。
        int[] arr = new  int[]{61,45,24,38,4,23,45};
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个数：");
        int num = input.nextInt();
        // 对数组进行选择排序处理，让数组从大到小排序
        for (int i = 0; i < arr.length; i++) {
            // 记录当前循环的值
            int temp = arr[i];
            // 记录当前循环的最大下标
            int maxInedx = i;
            // 从当前循环的下一位开始找最大值
            for (int j = i + 1; j < arr.length; j++) {
                // 计算本次最大下标
                if (arr[maxInedx] < arr[j]){
                    maxInedx = j;
                }
            }
            // 将最大值交换到当前记录值的位置
            arr[i] = arr[maxInedx];
            // 将当前的值放到刚刚找到最大值的位置上
            arr[maxInedx] = temp;
        }
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("数组长度为：" + arr.length);
        if (num <= arr.length){
            System.out.println("数组中第 " + num + " 大的数字为：" + arr[num - 1]);
        }else {
            System.out.println("输入的数超出了数组长度");
        }
    }
}
