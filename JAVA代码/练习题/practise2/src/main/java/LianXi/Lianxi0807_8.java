package LianXi;

import java.util.Random;
import java.util.Scanner;

public class Lianxi0807_8 {
    public static void main(String[] args) {
        // 7. 现有一个整数数组，数组中的每个元素都是[0-9]之间的数字，从数组的最大索引位置开始到最小索引位置，
        // 依次表示整数的个位、十位、百位。。。依次类推。请编写程序计算，这个数组所表示的整数值。
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个大于0的数字：");
//        int n = input.nextInt();
        int n = 3;
        int[] arr = new int[n];
        int sum = 0;
        int Index = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10);
            Index = i;
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
        System.out.println("最大索引：" + Index);

        switch (n) {
            case 3:
                sum = arr[0] * 100 + arr[1] * 10 + arr[2];
                break;
            case 2:
                sum = arr[0] * 10 + arr[1];
                break;
            case 1:
                sum = arr[0];
                break;
            default:
                System.out.println("dfdsfsfs");
        }
        System.out.println(sum);


    }
}
