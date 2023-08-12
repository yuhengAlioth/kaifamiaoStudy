package Practice.LX0811;

import java.util.Arrays;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0811
 * @文件名称：Lianxi05
 * @时间：2023/08/12/18:54
 */
public class Lianxi05 {
    public static void main(String[] args) {
        int[] arr = new  int[]{1,2,3,4,5,6};
        FanZhuan(arr);
    }
    // 翻转数组
    //编写一个方法，接受一个字符数组，将其翻转并输出。
    public static void FanZhuan(int[] arr){
        for (int i = 0,j = arr.length - 1; i < arr.length / 2; i++,j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}

