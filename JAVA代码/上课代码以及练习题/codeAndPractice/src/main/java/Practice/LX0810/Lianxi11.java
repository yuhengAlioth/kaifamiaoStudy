package Practice.LX0810;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0810
 * @文件名称：Lianxi11
 * @时间：2023/08/12/18:51
 */
public class Lianxi11 {
    public static void main(String[] args) {
        // 编写一个Jva程序，使用循环输出所有的完美数。
        // 完美数是等于其所有因子之和的正整数，如6=1+2+3。
        perfectNumber(10000);
    }
    public static void perfectNumber(int number) {
        for (int i = 1; i < number; i++) {
            int sum = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                System.out.println(sum);
            }
        }
    }
}

