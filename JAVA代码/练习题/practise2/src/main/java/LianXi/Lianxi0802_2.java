package LianXi;

import java.util.Scanner;

public class Lianxi0802_2 {
    public static void main(String[] args) {
//        编写一个程序，根据用户输入的温度单位("C"表示摄氏度，"F"表示华氏度)和温度，将其转换为另一种单位后输出。
//         注: 摄氏度转换为华氏度的公式(摄氏度 * 9 / 5)+32，以及华氏度转换为摄氏度的公式(华氏度-32) * 5 / 9
        Scanner input = new Scanner(System.in);
        System.out.println("请输入温度单位");
        String dw = input.next();
        System.out.println("请输入温度");
        double wd = input.nextDouble();
        double res = 0;
        switch (dw){
            case "C":
                res = (wd * 9 / 5) + 32;
                System.out.println("输入的温度是：" + wd + "\t" + dw + " 转换结果为：" + res + " F");
                break;
            case "F":
                res = (wd -32) * 5 / 9;
                System.out.println("输入的温度是：" + wd + "\t" +  dw + " 转换结果为：" + res + " C");
                break;
            default:
                System.out.println("输入的内容格式错误");
        }

    }
}
