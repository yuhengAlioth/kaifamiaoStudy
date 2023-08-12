package Code.ShuZu;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ShuZu
 * @文件名称：ShuZu
 * @时间：2023/08/12/17:25
 */
public class ShuZu {
    public static void main(String[] args) {
        // 定义数组并且初始化
        double[] a = new double[]{1.3,85.5,69.0};
        System.out.println(a[2]);
        // 数组长度
        System.out.println(a.length);
        // 定义动态数组并且初始化为 0
        int[] arr = new int[6];
        // 插入值
        arr[0] = 52;
        System.out.println(arr[1]);

        int[] sellMoney = new int[]{16, 26, 36, 6, 100};
        int sum = 0;
        for (int i = 0; i < sellMoney.length; i++) {
            System.out.print(sellMoney[i] + "\t");
            sum += sellMoney[i];
        }
        System.out.println();
        System.out.println("销售总额是" + sum);
    }
}

