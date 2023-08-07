package LianXi;

import java.util.Random;

public class Lianxi0807_3 {
    public static void main(String[] args) {
        // 2. 创建一个长度为6的整数数组。请编写代码，随机生成六个0（包含）-100（不包含）之间的整数存放到数组中，然后计算出数组中所有元素的和并打印。
        int[] arr = new int[6];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = new Random().nextInt(100);
            arr[i] = num;
        }
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            System.out.print("数组元素有：" + arr[i] + " ");
        }
        System.out.println(" ");
        System.out.println("数组元素的和为：" + sum);
    }
}
