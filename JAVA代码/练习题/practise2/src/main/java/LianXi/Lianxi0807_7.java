package LianXi;

import java.util.Random;
import java.util.Scanner;

public class Lianxi0807_7 {
    public static void main(String[] args) {
        // 6.定义一个长度为20的数组，元素为20-40的随机数，要求判断指定元素在数组中出现的次数，指定元素为键盘录入范围为20-40之间。
        int[] arr = new int[20];
        Scanner input = new Scanner(System.in);
        System.out.print("请输入范围为20-40之间的一个数字：");
        int num = input.nextInt();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(21) + 20;
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
        // 定义出现次数
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num){
                count ++;
            }
        }
        System.out.println(num + " 出现的次数为：" + count);
    }
}
