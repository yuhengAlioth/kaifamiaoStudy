package Code.forXunHuan;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code
 * @文件名称：ForLearn
 * @时间：2023/08/12/16:48
 */
public class DuiZhe {
    // for循环学习
    public static void main(String[] args) {
        // 定义纸张的厚度
        double h = 8848860;
        // 定义对折次数
        int c = 0;
        // 进行for循环计算对折次数
        for (double n = 0.1; n <= h; n *= 2){
            c ++;
        }
//        double i =0.1;
//        int n =0;
//        while(i<=8848860){
//            i *= 2;
//            n++;
//        }
        System.out.println("对折次数为：" + c);
    }
}

