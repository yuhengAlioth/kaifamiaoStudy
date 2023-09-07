package Practice.LX0907;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0907
 * @文件名称：Demo2
 * @代码功能：创建一个HashSet，包含一些单词。编写代码，找到集合中最长的单词
 * @时间：2023/09/07/21:30
 */
public class Demo2 {
    public static void main(String[] args) {
        HashSet wordSet = new HashSet<>();
        wordSet.add("aa");
        wordSet.add("bbb");
        wordSet.add("cccc");
        wordSet.add("ddddd");

        String longestWord = ""; // 最长单词

        Iterator iterator = wordSet.iterator();
        while (iterator.hasNext()) {
            String currentWord = (String) iterator.next();
            if (currentWord.length() > longestWord.length()) {
                longestWord = currentWord;
            }
        }

        System.out.println("最长单词：" + longestWord);
    }
}

