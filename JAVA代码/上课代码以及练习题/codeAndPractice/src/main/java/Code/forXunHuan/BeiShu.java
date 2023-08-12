package Code.forXunHuan;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.forXunHuan
 * @文件名称：BeiShu
 * @时间：2023/08/12/17:02
 */
public class BeiShu {
    public static void main(String[] args) {
        // 使用for循环输出所有7的倍数，直到200为止
        for (int i = 1;i <= 200; i++){
            if (i % 7 == 0){
                System.out.println(i);
            }
        }
    }
}

