package Code.forXunHuan;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.forXunHuan
 * @文件名称：ChengFaKouJue
 * @时间：2023/08/12/17:10
 */
public class ChengFaKouJue {
    public static void main(String[] args) {
        // 输出乘法口诀
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <=i ; j++) {
                sum = j * i;
                System.out.print(j + "x" + i + "=" + sum + "\t");
            }
            System.out.println();
        }
    }
}

