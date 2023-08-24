package Practice.LX0824;

import java.util.Arrays;
import java.util.Random;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0824.Marry
 * @文件名称：XinYun
 * @时间：2023/08/24/21:08
 */
public class XinYunNumber {
    public static void main(String[] args) {
        // 随机生成 20 个 1~ 40 之间的不重复幸运数字存储到数组中。
        // 要求: 数组中的数字乱序
        int[] arr = new int[20];
        Random ra = new Random();
        int count = 0;
        while (count < 20){
            int num = ra.nextInt(40) + 1;
            if (check(count,arr,num)){
                arr[count] = num;
                count++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static boolean check(int count,int[] arr,int num){
        for (int i = 0; i < count; i++) {
            if (arr[i] == num){
                return false;
            }
        }
        return true;
    }
}

