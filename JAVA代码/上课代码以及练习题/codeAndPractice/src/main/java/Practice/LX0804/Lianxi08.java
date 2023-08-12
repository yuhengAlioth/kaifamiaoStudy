package Practice.LX0804;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0804
 * @文件名称：Lianxi08
 * @时间：2023/08/12/18:31
 */
public class Lianxi08 {
    public static void main(String[] args) {
        // 输入行数 显示如图所示的空心三角形
        //      *
        //    *   *
        //  *       *
        //* * * * * * *
        int num = 4;
        for (int i = 1; i <= num; i++) { // 循环行数
            for (int j = 1; j <= num - i; j++) { // 循环输出空格
                System.out.print("  ");
            }
            if (i > 1 && i < num) {
                for (int j = 1; j <= i * 2 - 1; j++) { // 循环输出 *
                    if (j == 1 || j == 2 * i - 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            } else {
                for (int j = 1; j <= i * 2 - 1; j++) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}

