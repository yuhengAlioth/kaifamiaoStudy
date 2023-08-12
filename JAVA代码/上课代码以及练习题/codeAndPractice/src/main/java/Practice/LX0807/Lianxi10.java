package Practice.LX0807;

import java.util.Random;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0807
 * @文件名称：Lianxi10
 * @时间：2023/08/12/18:40
 */
public class Lianxi10 {
    public static void main(String[] args) {
        // 9. 在唱歌比赛中，有6名评委给选手打分，分数范围是[0 - 100]之间的整数。选手的
        // 最后得分为：去掉最高分、最低分后的4个评委的平均分，请完成上述过程并计算出选手的得分。
        int[] arr = new int[6];
        double sum = 0;
        double avg = 0;
        // 动态添加数据
        for (int i = 0; i < arr.length; i++) {
            arr[i] =  new Random().nextInt(101);
        }
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            // 找出最大值
            if (max < arr[i]) {
                max = arr[i];
            }
            // 找出最小值
            if (min > arr[i]) {
                min = arr[i];
            }
            sum += arr[i];
            System.out.print(arr[i] + " ");
        }
        avg = (sum - max - min) / 4;
        System.out.println(" ");
        System.out.println("最高分数：" + max);
        System.out.println("最低分数：" + min);
        System.out.println("去掉最高、最低分数后的平均成绩：" + avg);
    }
}

