package Practise06;

import java.util.Scanner;

public class Lianxi0808_5 {
    public static void main(String[] args) {
        // 添加数组元素,给定一个整数数组，输入位置 n 和值 k。将值 k 插入到数组的第 n 位并输出新数组的每一个元素。
        int[] arr = new int[]{15,2,65,84,68,23};
        // 定义新数组
        int[] newArr = new  int[7];
        Scanner input = new Scanner(System.in);
        System.out.print("请输入插入的位置：");
        int n = input.nextInt();
        System.out.print("请输入插入的值：");
        int k = input.nextInt();
        // 判断输入的数是否大于数组长度
        if (n <= newArr.length){
            // 循环新数组
            for (int i = 0, j = 0; i < newArr.length; i++) {
                if (i == n - 1){
                    newArr[i] = k;
                }else {
                    // 复制原来的数组
                    newArr[i] = arr[j];
                    j ++;
                }
            }
            System.out.println("原数组");
            for (int i : arr) {
                System.out.print(i + "\t");
            }
            System.out.println();
            System.out.println("新数组");
            for (int i : newArr) {
                System.out.print(i + "\t");
            }
        }else {
            System.out.println("插入的位置大于数组长度了原数组长度为：" + arr.length);
        }
    }
}
