package Practice.LX0829;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0829
 * @文件名称：QianZhui
 * @代码功能：最长公共前缀
 * @时间：2023/08/30/10:25
 */
public class QianZhui {
    public static void main(String[] args) {
        // 编写一个函数，接受一个字符串数组作为输入，返回这些字符串的最长公共前缀。
        String[] strings = {"we", "qwe", "qwe"};
        System.out.println(longPrefix3(strings));
    }
    public static String longPrefix(String[] strings) {
        String str = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() < str.length()) {
                str = strings[i];
            }
        }
        // 用最短的和后面的每一个比较
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }


    public static String longPrefix2(String[] strings) {
        String str = strings[0];
        for (int i = 1; i < strings.length; i++) {
            int j = 0;
            while (j < strings.length && j < strings[i].length()) {
                if (str.charAt(j) != strings[i].charAt(j)) {
                    break;
                }
                j++;
            }
            if (j == 0) {
                return "";
            }
            str = str.substring(0, j);
        }
        return str;
    }

    public static String longPrefix3(String[] strings) {
        String str = strings[0];
        // qwe we contains true indexOf = 1  0
        for (int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(str) != 0) {
                str = str.substring(0, str.length() - 1);
                if (str.isEmpty()) {
                    return str;
                }
            }
        }
        return str;
    }
}

