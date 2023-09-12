package Test.One;

import java.util.HashMap;

import static java.lang.Math.abs;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Test.One
 * @文件名称：MnaZu
 * @代码功能：判断数组中是否存在两个不同的索引i和j满足条件
 * @时间：2023/09/09/10:16
 */
public class MnaZu {
    //  `nums[i] == nums[j]` 且 `abs(i - j) <= k` 。如果存在，返回 `true` ；否则，返回 `false`
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println(isAnagram(nums, k));
        System.out.println(isAnagram(nums2, k2));
        System.out.println(isAnagram(nums3, k3));

    }

    public static boolean isAnagram(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

