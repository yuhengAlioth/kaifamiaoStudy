package Practice.LX0811;

import java.util.Arrays;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0811
 * @文件名称：Lianxi07
 * @时间：2023/08/12/18:55
 */
public class Lianxi07 {
    public static void main(String[] args) {
        // 编写一个方法，接受一个整数数组和一个正整数 k 作为参数，将数组中的元素左移 k 个位置。
        int[] nums = {1, 2, 3, 4, 5};
        int[] leftRemove = leftRemove(nums, 2);
        System.out.println(Arrays.toString(leftRemove));
    }

    public static int[] leftRemove(int[] arr, int k) {
        k %= arr.length;
        int[] newArr = new int[arr.length];
        // arr[1, 2, 3, 4, 5]    2 newArr [3, 4, 5, 1, 2]
        // 原数组  原数组开始复制的位置  新数组  新数组开始赋值的位置  复制的长度
        System.arraycopy(arr, k, newArr, 0, arr.length - k);
        System.arraycopy(arr, 0, newArr, arr.length - k, k);
        return newArr;

    }
}

