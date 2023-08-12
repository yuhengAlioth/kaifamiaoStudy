package Practice.LX0810;

import java.util.Random;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0810
 * @文件名称：Lianxi01
 * @时间：2023/08/12/18:47
 */
public class Lianxi01 {
    public static void main(String[] args) {
        // 定义一个5*5的二维数组并初始化，找出数组中的最大值的坐标。
        int[][] arr = new int[5][5];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = rand.nextInt(100);
            }
        }
        int max = arr[0][0];
        int x = 0;
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > max){
                    max = arr[i][j];
                    x = i + 1;
                    y = j + 1;
                }
            }
        }
        System.out.print("最大值为：" + max);
        System.out.println();
        System.out.print(x + ","+ y);
        System.out.println();
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}

