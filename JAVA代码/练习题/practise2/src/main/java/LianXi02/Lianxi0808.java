package LianXi02;

import java.util.Random;

public class Lianxi0808 {
    public static void main(String[] args) {
        // 成绩排名,一个班级有若干学生，每个学生的成绩以整数表示。
        // 动态初始化数组
        int[] arr = new int[6];
        Random rand = new Random();
        // 给数组插入值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(101);
        }
        for (int i = 0; i < arr.length; i++) {
            // 记录当前循环的值
            int temp = arr[i];
            // 记录当前循环的最大下标
            int maxInedx = i;
            // 从当前循环的下一位开始找最大值
            for (int j = i + 1; j < arr.length; j++) {
                // 计算本次最大下标
                if (arr[maxInedx] < arr[j]){
                    maxInedx = j;
                }
            }
            // 将最大值交换到当前记录值的位置
            arr[i] = arr[maxInedx];
            // 将当前的值放到刚刚找到最大值的位置上
            arr[maxInedx] = temp;
        }
        System.out.print("排名");
        System.out.print("\t成绩");
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + 1);
            System.out.print("\t\t");
            System.out.print(arr[i]);
            System.out.println(" ");
        }
    }
}
