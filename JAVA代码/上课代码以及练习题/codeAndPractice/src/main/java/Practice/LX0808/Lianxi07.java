package Practice.LX0808;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0808
 * @文件名称：Lianxi07
 * @时间：2023/08/12/18:44
 */
public class Lianxi07 {
    public static void main(String[] args) {
        // 查找元素,给定一个整数数组，输入一个值`n`，输出`n`在数组中的下标(如果不存在输出`-1`)
        int[] arr = new int[]{12, 5, 35, 85, 15};
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个数：");
        int num = input.nextInt();
        // 初始化下标
        int index = -1;
        // 判断是否存在
        boolean isFound = false;
        for (int i = 0; i < arr.length; i++) {
            // 如果存在改变变量
            if (num == arr[i]) {
                index = i;
                isFound = true;
                break;
            }
        }
        if (isFound){
            System.out.println(num + "在数组中所在下标为：" + index);
        }else {
            System.out.println(index);
        }
    }
}

