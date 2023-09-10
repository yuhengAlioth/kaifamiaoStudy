package Test.One;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Test.One
 * @文件名称：YiWei
 * @代码功能：判断t是否是s的字母异位词
 * @时间：2023/09/09/9:38
 */
public class YiWei {
    public static void main(String[] args) {
        String s = "rat";        String t = "car";
        String s2 = "anagram";
        String t2 = "nagaram";
        System.out.println(isAnagram2(s, t));
        System.out.println(isAnagram2(s2, t2));
    }

    public static boolean isAnagram2(String s, String t) {
        // 如果两个字符串长度不同，则它们一定不是字母异位词
        if (s.length() != t.length()) {
            return false;
        }

        // 将两个字符串转换为字符数组
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        // 对它们进行排序
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // 比较排序后的字符数组是否相等
        return Arrays.equals(sArray, tArray);
    }


    public static boolean isAnagram(String s, String t) {

        // 如果两个字符串长度不同，则它们一定不是字母异位词
        if (s.length() != t.length()) {
            return false;
        }

        // 创建一个HashMap来存储字符及其出现次数
        HashMap<Character, Integer> map = new HashMap<>();

        // 遍历字符串s，将每个字符及其出现次数存储到HashMap中
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 遍历字符串t，将每个字符在HashMap中的计数减一
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }

        // 最后检查HashMap中所有字符的计数是否都为零
        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

}





