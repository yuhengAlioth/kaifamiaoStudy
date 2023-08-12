package Code.forXunHuan;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.forXunHuan
 * @文件名称：SuShu
 * @时间：2023/08/12/17:25
 */
public class SuShu {
    public static void main(String[] args) {
        //  找100以内的素数
        //  只能1和他本身整除的数字就是素数
        // i % 1 == 0
        outer : for (int i = 1; i <= 100; i ++) {
            int count = 0; // 统计能整除的数量
            for (int j = 1; j <= i; j ++) { // j = 1  count = 1 j = 2  count = 1 j = 3  count = 2  j = 4
                if (i % j == 0) {
                    count ++;
                }
                if (count > 2) {
                    continue outer;
                }
            }
            if (count == 2) {
                System.out.println(i + "是素数");
            }
        }
    }
}

