package Practise08;

/**
 * @作者：玉蘅
 * @项目名称：practise2
 * @包名：Practise08
 * @文件名称：Lianxi0810_9
 * @时间：2023/08/10/20:23
 */
public class Lianxi0810_9 {
    public static void main(String[] args) {
        // 编写一个Java程序，使用循环计算π的近似值。
        // 可以使用Leibniz级数来近似π的值：π=4*（1-1/3+1/5-1/7+1/9-1/11+··.),通过增加级数项的数量来改进近似结果。
        double res = isPI(100000000);
        System.out.println("PI的近似值 = " + res);
    }
    public static double isPI(int num){
        double res= 0;
        for (int i = 1; i < num; i++) {
            if (i % 2 == 0){
                res += - 1.0/(2 * i -1);
            }else {
                res += 1.0/(2 * i -1);
            }
        }
        return 4 * res;
    }

}

