package Practise09;

import java.util.Arrays;

/**
 * @作者：玉蘅
 * @项目名称：practise2
 * @包名：Practise09
 * @文件名称：Lianxi0811_7
 * @时间：2023/08/11/20:39
 */
public class Lianxi0811_7 {
    public static void main(String[] args) {
        int[] arr = new int[]{125,52,63,48,56};
        int key1 = 5;
        int key2 = 1;
        JiaoHuan(arr,key1,key2);
    }
    // 交换元素位置
    // 编写一个方法，接受一个整数数组和两个索引作为参数，交换数组中指定索引位置的两个元素。
    public static void JiaoHuan(int[] arr,int key1,int key2){
        System.out.println("原数组：" + Arrays.toString(arr));
        System.out.println();
        if (key1 <= arr.length && key2 <= arr.length){
            int temp = arr[key1 - 1];
            arr[key1 - 1] = arr[key2 - 1];
            arr[key2 - 1] = temp;
            System.out.println("交换后的数组：" + Arrays.toString(arr));
        }else {
            System.out.print("请输入正确的数组交换位置");
        }

    }
}

