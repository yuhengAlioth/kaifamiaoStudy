package Test.One;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Test.One
 * @文件名称：FanZhuan
 * @代码功能：反转字符串中单词的顺序
 * @时间：2023/09/09/9:12
 */
public class FanZhuan {
    public static void main(String[] args) {
        String s = "the sky is blue";
        String s2 = "  hello word";
        String s3 = "a good   example";

        System.out.println(reverseWords(s));
        System.out.println(reverseWords(s2));
        System.out.println(reverseWords(s3));
    }
    public static String reverseWords(String s) {
        // 去除字符串两端的空格
//        s = s.trim();
        s = s.strip();

        // 以空格分割字符串为单词数组
        // \s 表示空格 + 表示多个
        String[] words = s.split("\\s+");

        // 创建StringBuilder用于构建结果字符串
        StringBuilder res = new StringBuilder();

        // 从后向前遍历单词数组
        for (int i = words.length - 1; i >= 0; i--) {
            // 添加单词到结果字符串
            res.append(words[i]);
            // 除了最后一个单词，每个单词后都需要添加空格
            if (i != 0) {
                res.append(" ");
            }
        }

        // 返回结果字符串
        return res.toString();
    }
}

