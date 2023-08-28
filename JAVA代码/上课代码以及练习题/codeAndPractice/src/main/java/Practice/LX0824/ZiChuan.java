package Practice.LX0824;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0824
 * @文件名称：ZiChuan
 * @代码功能：最长子串
 * @时间：2023/08/28/11:47
 */
public class ZiChuan {
    public static void main(String[] args) {
        // 最长无重复子串
        System.out.println(getSon("asdfghahjkldsd"));
    }

    public static String getSon(String str) {
        // 拆分成字符数组   abcabc
        // 从数组第一位开始找重复值 每一位开始计数，找到重复值就计数结束，再从下一位开始找
        char[] chars = str.toCharArray();
        String finalResult = ""; // 最终的最长的
        for (int i = 0; i < chars.length; i++) {
            String result = ""; // 本轮的不重复子串
            char c = chars[i];
            result += c;
            int index = i + 1;
            // 找到当前不重复的子串 result  要判断是否存在  indexOf()  -1 不存在 contains true false  subString(beginIndex) beginIndex-结尾  subString(beginIndex, endIndex) [beginIndex, endIndex)
            for (; index < chars.length && result.indexOf(chars[index]) == -1; ) {
                result += chars[index];
                index++;
            }
            // 判断当前这个字符串的长度  如果大于最大长度，就把最终结果赋值成result
            if (result.length() > finalResult.length()) {
                finalResult = result;
            }
        }
        return finalResult;

    }

}

