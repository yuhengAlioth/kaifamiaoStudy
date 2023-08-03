package LianXi;

public class Lianxi0803_4 {
    public static void main(String[] args) {
//        编写程序输出1到100之间的质数和。
        int sum = 0;
        outer : for (int i = 1; i <= 100; i ++) {
            int count = 0; // 统计能整除的数量
            for (int j = 1; j <= i; j ++) {
                // 从1到i的判断整除的组数
                if (i % j == 0) {
                    count ++;
                }
                // 大于2组跳出本次循环
                if (count > 2) {
                    continue outer;
                }
            }
            if (count == 2) {
                sum += i;
            }
        }
        System.out.println("100以内质数和为：" + sum);
    }
}
