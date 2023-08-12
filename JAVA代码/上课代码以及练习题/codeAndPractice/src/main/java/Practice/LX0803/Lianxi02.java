package Practice.LX0803;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0803
 * @文件名称：Lianxi02
 * @时间：2023/08/12/18:25
 */
public class Lianxi02 {
    public static void main(String[] args) {
        // 第一块
        for (int i = 1;i < 3;i ++){
            //   计算空格
            for (int j = 8;j > i;j --){
                System.out.print(" ");
            }
            for(int a = 1;a <= i;a ++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
        // 第二块
        for (int i = 3;i < 5;i ++){
            //   计算空格
            for (int j = 7;j > i;j --){
                System.out.print(" ");
            }
            for(int a = 3;a <= i*2-1;a ++){
                System.out.print(" *");
            }
            System.out.println(" ");
        }
        for(int a = 3;a > 2;a --){
            for(int q = 7;q >= a;q --){
                System.out.print(" ");
            }
            for (int g = 3;g <= a*2-1;g ++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
        // 第三块
        for (int i = 5;i < 7;i ++){
            //   计算空格
            for (int j = 7;j > i;j --){
                System.out.print(" ");
            }
            for(int a = 5;a <= i*2-1;a ++){
                System.out.print(" *");
            }
            System.out.println(" ");
        }
        for(int a = 5;a > 4;a --){
            for(int q = 7;q >= a;q --){
                System.out.print(" ");
            }
            for (int g = 5;g <= a*2-1;g ++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
        // 第四块
        for (int i = 7;i < 9;i ++){
            //   计算空格
            for (int j = 8;j > i;j --){
                System.out.print(" ");
            }
            for(int a = 7;a < i * 2 ;a ++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
        // 第五块
        for (int i = 1; i < 5;i ++){
            //   计算空格
            System.out.println("     * * * *");
        }
    }
}

