package Practice.LX0830;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0830
 * @文件名称：WordBreak
 * @代码功能：字符串的拆分
 * @时间：2023/08/30/21:25
 */
public class WordBreak {
    public static void main(String[] args) {
        // 给定一个非空字符串和一个包含非空单词列表的字典，编写一个函数来确定字符串是否可以被空格拆分为一个或多个字典中的单词。
        String string = "printfhello";
        String[] wordDict = {"printf", "hello"};
        System.out.println(wordBreak(string, wordDict)); // 输出: true
    }

    public static boolean wordBreak(String s, String[] wordDict) {
        int count = 0;
        for (int i = 0; i < wordDict.length; i++) {
            for (int j=0;j<s.length();j++) {
                String str = s.substring(0, j);
                if (str.equals(wordDict[i])) {
                    count = j;
                    String str2 = s.substring(count);
                    if (str2.equals(wordDict[i+1])){
                        return true;
                    }

                }
            }
        }
        return false;
    }
}

