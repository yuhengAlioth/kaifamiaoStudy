package Practice.LX0911;

import java.util.Arrays;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0911
 * @文件名称：Avg
 * @代码功能：有一个整数集合，求每个元素平方的平均值
 * @时间：2023/09/11/21:11
 */
public class Avg {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(23, 12, 6, 77, 48, 5);
        double average = numbers.stream()
//                .mapToDouble(num -> num * num) // 将每个元素平方
                .mapToDouble(num -> Math.pow(num,2)) // 将每个元素平方+
                .average() // 求平均值
                .orElse(0.0); // 如果集合为空，设置默认值

        System.out.println("每个元素平方的平均值：" + average);

    }

}
