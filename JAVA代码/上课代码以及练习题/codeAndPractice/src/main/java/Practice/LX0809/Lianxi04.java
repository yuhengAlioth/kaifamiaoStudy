package Practice.LX0809;

import java.util.Arrays;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0809
 * @文件名称：Lianxi04
 * @时间：2023/08/12/18:46
 */
public class Lianxi04 {
    public static void main(String[] args) {
        // 复制数组
        int[] nums = {2, 11, 33, 44, 55, 66, 277};
        int[] newNums = new int[nums.length - 1];
        int key = 33;
        int keyIndex = -1;
        // 找到下标
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key){
                keyIndex = i;
            }
        }
        // for循环
        if (keyIndex < 0){
            System.out.println("数字不存在");
        }else {
            for (int i = 0; i < newNums.length; i++) {
                if (i < keyIndex){
                    // 复制删除之前的值到新数组里面
                    newNums[i] = nums[i];
                }else {
                    // 复制删除值后面的到新数组
                    newNums[i] = nums[i + 1];
                }
            }
            System.out.println(Arrays.toString(newNums));
        }
        System.out.println("===========================================");
        // System 类中的 arraycopy 方法实现 删除元素
        if (keyIndex < 0) {
            System.out.println("数字不存在");
        } else {
            System.arraycopy(nums, 0, newNums, 0, keyIndex);
            System.arraycopy(nums, keyIndex + 1, newNums, keyIndex, newNums.length - keyIndex);
            System.out.println(Arrays.toString(newNums));
        }
    }
}

