package Practise07;

public class Lianxi0809_3 {
    public static void main(String[] args) {
        // 杨辉三角
        // 需求：打印杨辉三角形（行数可以键盘录入）
        // 分析：看这种图像的规律
        //A:任何一行的第一列和最后一列都是1
        //B:从第三行开始，每一个数据是它上一行的前一列和它上一行的本列之和。
        //步骤：
        //A：首先定义一个二维数组。行数如果是n,我们把列数也先定义为n。这个n的数据来自于键盘录入。
        //B：给这个二维数组任何一行的第一列和最后一列赋值为1
        //C：按照规律给其他元素赋值从第三行开始，每一个数据是它上一行的前一列和它上一行的本列之和。
        //D:遍历这个二维数组。
        int[][] tree = new int[6][6];
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j <= i; j++) {
                // 第一个和最后一个都是1
                if (j == 0 || j == i) {
                    tree[i][j] = 1;
                } else {
                    tree[i][j] = tree[i - 1][j] + tree[i - 1][j - 1];
                }
            }
        }
        for (int[] ints : tree) {
            for (int ints2 : ints) {
                if (ints2 != 0){
                    System.out.print(ints2 + "\t");
                }
            }
            System.out.println();
        }
    }
}
