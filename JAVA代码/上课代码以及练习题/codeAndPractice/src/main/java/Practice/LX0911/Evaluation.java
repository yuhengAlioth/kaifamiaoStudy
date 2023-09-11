package Practice.LX0911;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0911
 * @文件名称：Evaluation
 * @代码功能：有一个整数集合，分别完成以下操作：所有元素之和、最⼤值、最⼩值
 * @时间：2023/09/11/19:32
 */
public class Evaluation {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(23, 12, 6, 77, 48, 0);
        Stream<Integer> stream = numbers.stream();

        int sum = (int) stream.reduce(0, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return (int)integer + (int)integer2;
            }
        });

        int min = (int) numbers.stream().min(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (int)o1 - (int)o2;
            }
        }).get();

        int max = (int) numbers.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (int)o1 - (int)o2;
            }
        }).get();

        int sum2 = (int) numbers.stream().reduce(0,(a,b) -> (int) a + (int) b);
        int min2 = (int) numbers.stream().min((a,b) -> (int) a - (int) b).get();
        int max2 = (int) numbers.stream().max((a,b) -> (int) a - (int) b).get();

        System.out.println("最小值：" + min);
        System.out.println("最大值：" + max);
        System.out.println("和：" + sum);

        System.out.println("最小值：" + min2);
        System.out.println("最大值：" + max2);
        System.out.println("和：" + sum2);

    }

}

