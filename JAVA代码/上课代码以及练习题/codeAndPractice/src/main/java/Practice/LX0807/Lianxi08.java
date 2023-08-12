package Practice.LX0807;

import java.util.Random;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0807
 * @文件名称：Lianxi08
 * @时间：2023/08/12/18:38
 */
public class Lianxi08 {
    public static void main(String[] args) {
        // 7. 现有一个整数数组，数组中的每个元素都是[0-9]之间的数字，从数组的最大索引位置开始到最小索引位置，
        // 依次表示整数的个位、十位、百位。。。依次类推。请编写程序计算，这个数组所表示的整数值。
        long[] arr = new long[19]; // 初始化一个长度为19的数组
        Random random = new Random(); // 获取创建随机数的对象
        for (int i = 0; i < arr.length; i++) { // 把随机数放到数组里面
            arr[i] = random.nextLong(10);
        }
        long sum = 0; // 最终要打印的结果
        for (int i = 0; i < arr.length; i++) { // 构建要打印的结果
            System.out.print(arr[i] + "\t");
            int zero = 1;
            for (int j = 0; j < arr.length - i - 1; j ++) {  // 2, 4, 8, 1, 2, 3, 3, 0, 6, 7
                zero *= 10;      // 每一位 * 10 ^ (length - 1 - i)
            }
            sum += arr[i] * zero;
        }
        System.out.println();
        System.out.println(sum);
    }
}

