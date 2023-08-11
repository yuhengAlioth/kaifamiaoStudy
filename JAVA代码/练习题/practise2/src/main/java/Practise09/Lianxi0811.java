package Practise09;

import java.util.Random;

/**
 * @作者：玉蘅
 * @项目名称：practise2
 * @包名：Practise09
 * @文件名称：Lianxi0811
 * @时间：2023/08/11/11:08
 */
public class Lianxi0811 {
    // 1 --> 浇水 2 --> 修剪 3 --> 打药  4 --> 生虫
    static int grow = 11; // 树初始成长值，当成长值 归零或小于0时，树死亡
    static  int count = 0;
    public static void main(String[] args) {
        // 获取操作次数
        // 生成随机数
        Random rand = new Random();
        int type = rand.nextInt(4) + 1;
        int cishu = 3; //操作次数
        for (int i = 1; i <= cishu ; i++) {
//            System.out.println(type);
            // 分支 按照type执行不同的方法
            switch (type) {
                case 1:
                    water();
                    break;
                case 2:
                    cut();
                    break;
                case 3:
                    fertilize();
                    break;
                case 4:
                    worms();
                    break;
            }

        }
        if (grow <= 0){
            System.out.println("树死了");
        }else {
            System.out.print("最终成长值为：" + grow);
        }
        System.out.println();

    }

    /**
     * 浇水，每浇一次水成长值 +10
     */
    public static void water() {
        grow += 10;
        System.out.println("浇水,成长值 +10  当前成长值为：" + grow);
    }

    /**
     * 修剪树，每修剪一次成长值 +5
     */
    public static void cut() {
        grow += 5;
        System.out.println("修剪树,成长值 +5  当前成长值为：" + grow);
    }

    /**
     * 打药，每打药一次成长值 +20
     */
    public static void fertilize() {
        grow += 20;
        System.out.println("打药,成长值 +20  当前成长值为：" + grow);
    }

    /**
     * 生虫，每生虫一次成长值 -10
     * 连续生虫三次，生长值额外 - 20
     */
    public static void worms() {
        count ++;
        if (count == 3) {
            grow -= 30;
            System.out.println("连续生虫3次,成长值额外 -20  当前成长值为：" + grow);
            count = 0;
        } else {
            grow -= 10;
            System.out.println("生虫,成长值 -10  当前成长值为：" + grow);
        }
    }
}

