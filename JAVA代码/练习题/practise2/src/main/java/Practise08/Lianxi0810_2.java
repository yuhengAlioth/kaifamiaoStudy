package Practise08;

import java.util.Random;

/**
 * @作者：玉蘅
 * @项目名称：practise2
 * @包名：Practise08
 * @文件名称：Lianxi0810_2
 * @时间：2023/08/10/14:47
 */
public class Lianxi0810_2 {
    public static void main(String[] args) {
        //定义一个5*5的二维数组并初始化，找出最小值的坐标，计算出该坐标周边的所有元素之和
        int[][] arr = new int[5][5];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = rand.nextInt(100);
            }
        }
        int min = arr[0][0];
        int x = 0;
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        System.out.print("最小值为：" + min);
        System.out.println();
        System.out.print(x + "," + y);
        System.out.println();
        int sum = (y == 0 ? 0 : arr[x][y - 1]) //左边
                + (y == arr[0].length - 1 ? 0 : arr[x][y + 1]) //右边
                + (x == 0 ? 0 : arr[x - 1][y]) //正上方
                + (x == arr.length - 1 ? 0 : arr[x + 1][y]) // 正下方
                + (x == 0 || y == 0 ? 0 : arr[x - 1][y - 1]) //斜左上方
                + (x == 0 || y == arr[0].length - 1 ? 0 : arr[x - 1][y + 1]) // 斜右上方
                + (y == 0 || x == arr.length - 1 ? 0 : arr[x + 1][y - 1]) //斜左下方
                + (x == arr.length - 1 || y == arr[0].length - 1 ? 0 : arr[x + 1][y + 1]); //斜右下方
        System.out.println(sum);
    }

}

