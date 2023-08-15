package Code.PaiXu;

import java.util.Arrays;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.PaiXu
 * @文件名称：KuaiSu
 * @时间：2023/08/15/10:44
 */
public class KuaiSu {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 0, -1, 2, -9};
        kuaiPai(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    public static void kuaiPai(int[] arr,int left,int right){
        if (left >= right) {
            return;
        }
        // 定义一个基准值
        int temp = arr[left];
        // 左边下标
        int i = left;
        // 右边下标
        int j = right;
        // 当 i == j 是基准值放的位置
       while (i != j){
           // 找出比基准小的值的下标
           while (j > i && arr[j] >= temp){
               j --;
           }
           // 找出比基准大的值的下标
           while (j > i && arr[i] <= temp){
               i ++;
           }
           // 将两个值交换位置
           if (i < j){
               arr[j] = arr[i] ^ arr[j];
               arr[i] = arr[i] ^ arr[j];
               arr[j] = arr[i] ^ arr[j];
           }
       }
       // 基准值和找到放基准位置的值进行比较交换位置
        if (arr[i] < temp) {
            arr[left] = arr[i];
            arr[i] = temp;
        }
        // 数组以 i 下标分成左边 和右边两部分   i 左边 小于 基准值  i 右边比基准值大
        // 排序左边
        kuaiPai(arr, left, i - 1);
        // 排序右边
        kuaiPai(arr, i + 1, right);
    }
}

