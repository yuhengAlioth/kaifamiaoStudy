package Practice.LX0807;

import java.util.Random;
import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0807
 * @文件名称：Lianxi05
 * @时间：2023/08/12/18:36
 */
public class Lianxi05 {
    public static void main(String[] args) {
        // 4.按要求在main方法中完成以下功能：
        //PS：输入的数组元素范围包括1和60，不需要代码判断
        int[] arr = new int[5];
        Scanner input = new Scanner(System.in);
        System.out.print("输入5个1-60之间的数字作为数组元素；");
        //b. 生成2-10（范围包含2和10）之间的随机数num
        int num = new Random().nextInt(9) + 2;
        //a. 定义一个长度为5的int型数组arr，提示用户输入5个1-60之间的数字作为数组元素
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();;
            //c. 遍历数组arr,筛选出数组中不是num倍数的元素并输出
            if (arr[i] % num != 0){
                System.out.println("不是" + num + "的倍数的元素是：" + arr[i]);
            }
        }
    }
}

