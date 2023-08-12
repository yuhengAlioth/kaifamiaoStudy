package Practice.LX0804;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0804
 * @文件名称：Lianxi02
 * @时间：2023/08/12/18:28
 */
public class Lianxi02 {
    public static void main(String[] args) {
        // 打印100以内除了尾数为3,5,7的所有数
        boolean s = true;
        for ( int i = 1;i <= 100; i ++){
            if (i % 10 != 3 && i % 10 != 5 && i % 10 != 7){
                System.out.println(i);
            }
        }
    }
}

