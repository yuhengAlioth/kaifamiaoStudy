package org.example;

public class ChaRu {
    public static void main(String[] args) {
        // 插入排序
        int[] arr = new int[]{12,56,3,47,785,11,58};
        // 对数组进行循环
        for (int i = 0; i < arr.length - 1; i++) {
            // 将数组的第 i + 1 的数拿出来
            int temp = arr[i + 1];
            // 拿到 i 的下标
            int index = i;
            // 对拿出来的值和前面排完序的值进行比较
            for (;index >= 0 && temp < arr[index];index --){
                arr[index + 1] = arr[index];
            }
            // 跳出循环进行换值操作
            arr[index + 1] = temp;
        }

        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}
