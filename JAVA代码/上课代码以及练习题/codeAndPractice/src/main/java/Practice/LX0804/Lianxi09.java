package Practice.LX0804;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0804
 * @文件名称：Lianxi09
 * @时间：2023/08/12/18:33
 */
public class Lianxi09 {
    public static void main(String[] args) {
        // 一个循环，打印输出一个由字符构成的正方形图案，其中边长由用户输入确定。要求字符按照以下顺序循环使用：**'#' , '@', '\*'**。
        int n = 6;
        System.out.println(Math.pow(12, 2));
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == n) {
                for (int j = 1; j <= n; j ++) {
                    if (j == 1 || j == n) {
                        System.out.print("\t#");
                    } else {
                        System.out.print("\t@");
                    }
                }
            } else {
                for (int j = 1; j <= n; j ++) {
                    if (j == 1 || j == n) {
                        System.out.print("\t@");
                    } else {
                        System.out.print("\t*");
                    }
                }
            }
            System.out.println();
        }
    }
}

