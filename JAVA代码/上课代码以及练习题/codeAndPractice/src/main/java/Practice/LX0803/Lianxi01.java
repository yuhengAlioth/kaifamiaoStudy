package Practice.LX0803;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0803
 * @文件名称：Lianxi01
 * @时间：2023/08/12/18:24
 */
public class Lianxi01 {
    public static void main(String[] args) {
        for (int i=1;i< 7;i++){
            for (int j=7;j>i;j--){
                System.out.print(" ");
            }
            for(int a=1;a<=i*2-1;a++){ //i*2-1
                System.out.print("*");
            }
            System.out.println(" ");
        }
        for(int a=6;a>=1;a--){
            for(int q=6;q>=a;q--){
                System.out.print(" ");
            }
            for (int g=1;g<=a*2-1;g++){
                System.out.print("*");
            }
            System.out.println(" ");
        }

        // 2倍数
        for (int i = 1;i < 7;i ++){
            for (int j = 7;j > i;j --){
                System.out.print(" ");
            }
            for(int a = 1;a <= i*2;a ++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
        for(int a = 6;a >= 1;a --){
            for(int q = 6;q >= a;q --){
                System.out.print(" ");
            }
            for (int g = 1;g <= a*2;g ++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}

