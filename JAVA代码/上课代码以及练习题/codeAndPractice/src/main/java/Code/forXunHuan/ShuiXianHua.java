package Code.forXunHuan;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code
 * @文件名称：ShuiXianHua
 * @时间：2023/08/12/16:53
 */
public class ShuiXianHua {
    public static void main(String[] args) {
        // 输出所有的水仙花数字
        // 水仙花数字为三位数,每一位的立方和等于本身
        System.out.println("所有的水仙花数：");
        for (int i = 100; i <= 999 ; i++) {
            // 分解三位数
            int a = i / 100; // 获取百分位数字
            int b = i / 10 % 10; // 获取十分位数字
            int c = i % 10; // 获个位数字
            int res = a*a*a + b*b*b + c*c*c;
            // 满足水仙花数条件输出
            if (res == i){
                System.out.print("水仙花数有：" + res + "\t");
            }
        }
    }
}

