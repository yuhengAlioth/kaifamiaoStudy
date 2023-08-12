package Code.FangFa;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.FangFa
 * @文件名称：DiGui
 * @时间：2023/08/12/17:23
 */
public class DiGui {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入所求斐波那次数列的位数：");
        int num = input.nextInt();
        System.out.println("在斐波那次数列中第" + num + "位是：" + feiBo(num));
    }
    public static int feiBo(int num){
        // 使用递归实现斐波那次数列
        if(num == 1 || num == 2){
            return 1;
        }
        return feiBo(num - 1) + feiBo(num - 2);
    }
}

