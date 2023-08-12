package Practice.LX0810;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0810
 * @文件名称：Lianxi09
 * @时间：2023/08/12/18:50
 */
public class Lianxi09 {
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

