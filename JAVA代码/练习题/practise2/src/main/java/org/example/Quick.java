package org.example;

import java.util.Arrays;

/**
 * @作者：玉蘅
 * @项目名称：practise2
 * @包名：org.example
 * @文件名称：Quick
 * @代码功能：快速排序
 * @时间：2023/08/25/20:43
 */
public class Quick {
    public static void main(String[] args) {
        int[] arr = {122,55,-5,3,45,3,32};
        quick(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
    private static void quick(int[] arr,int left,int right){
//        当左边的下标大于右边时停止循环
        while (left >= right){
            return;
        }
        int temp = arr[left];
        int i = left;
        int j = right;
//        当两个下标不相等时进入循环
        while (i != j){
//            从右边开始往左找比基准值小的数
            while (j > i && arr[j] >= temp){
                j --;
            }
//            从左边开始往右找比基准值大的值
            while (j > i && arr[i] <= temp){
                i ++;
            }
            if (i < j){
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
            }
        }
        if (arr[i] < temp){
            arr[left] = arr[i];
            arr[i] = temp;
        }
        quick(arr,left,i - 1);
        quick(arr,i + 1,right);
    }
}
