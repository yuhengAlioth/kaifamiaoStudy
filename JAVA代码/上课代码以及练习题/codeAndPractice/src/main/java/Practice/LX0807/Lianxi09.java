package Practice.LX0807;

import java.util.Random;
import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0807
 * @文件名称：Lianxi09
 * @时间：2023/08/12/18:39
 */
public class Lianxi09 {
    public static void main(String[] args) {
        // 8. 定义一个数组其中包含多个数字。用自己的方式最终实现，奇数放在数组的左边，
        // 偶数放在数组的右边。（可以创建其他数组，不必须在原数组中改变）
        Scanner input = new Scanner(System.in);
        System.out.print("请输入数组的长度：");
        int num = input.nextInt();
        int[] arr1 = new int[num];
        int[] arr2 = new int[num];
        int count = 0;
        for (int i = 0; i < num; i++) {
            arr1[i] = new Random().nextInt(num * 9);
        }
        // 把奇数先放进去
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] % 2 != 0){
                arr2[count] = arr1[i];
                count ++;
            }
        }
        // 再放入偶数
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] % 2 ==0) {
                arr2[count] = arr1[i];
                count ++;
            }
        }
        System.out.println("原数组：");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println(" ");
        System.out.println("现数组：");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}

