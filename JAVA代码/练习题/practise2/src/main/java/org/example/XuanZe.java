package org.example;

public class XuanZe {
    public static void main(String[] args) {
        // 选择排序
        int[] arr = new int[]{12,56,3,47,785,11,58};
        // 开始循环数组
        for (int i = 0; i < arr.length; i++) {
            // 记录当前循环的值
            int temp = arr[i];
            // 记录当前循环的最小下标
            int minInedx = i;
            // 从当前循环的下一位开始找最小值
            for (int j = i + 1; j < arr.length; j++) {
                // 计算本次最小下标
                if (arr[minInedx] > arr[j]){
                    minInedx = j;
                }
            }
            // 将最小值交换到当前记录值的位置
            arr[i] = arr[minInedx];
            // 将当前的值放到刚刚找到最小值的位置上
            arr[minInedx] = temp;
        }
        for (int i : arr) {
            System.out.print(i + "\t");
        }

    }
}
