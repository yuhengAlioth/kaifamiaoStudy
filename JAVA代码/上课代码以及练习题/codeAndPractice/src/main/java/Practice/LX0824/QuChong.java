package Practice.LX0824;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0824
 * @文件名称：QuChong
 * @时间：2023/08/24/21:11
 */
public class QuChong {

    public static void main(String[] args) {
        // 去除重复字符
        //编写一个程序，去除字符串中的重复字符。
        //例如：输入 asdfgnasd ，输出 asdfgn
        String str = "asdfgnasd";
        System.out.print("原来的字符串为：" + str);
        char[] charArray = str.toCharArray();
        int k = charArray.length - 1;
        for (int i = 0; i < k; i++) {
            if (charArray[k] == charArray[i]) k--;
            for (int j = i + 1; j <= k ; j++) {
                if (charArray[i] == charArray[j]){
                    char temp = charArray[j];
                    charArray[j] = charArray[k];
                    charArray[k] = temp;
                    k--;
                }
            }
        }
        System.out.println();
        System.out.print("去重的字符串为：");
        for (int i = 0; i <= k + 1; i++) {
            System.out.print(charArray[i]);
        }
    }
}

