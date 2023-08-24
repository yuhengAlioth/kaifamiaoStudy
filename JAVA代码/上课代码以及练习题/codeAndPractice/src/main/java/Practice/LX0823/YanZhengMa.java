package Practice.LX0823;

import java.util.Random;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0823
 * @文件名称：YanZhengMa
 * @时间：2023/08/23/19:36
 */
public class YanZhengMa {
    public static void main(String[] args) {
        // 实现随机产生验证码，验证码的每位可能是数字、大写字母、小写字母。
        int num = 6; // 验证码位数
        generateCode(num);
    }
    private static void generateCode(int num){
        Random random = new Random();
        String str = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String code = "";
        System.out.print("随机验证码为：");
        for (int i = 0; i < num; i++) {
            int index = random.nextInt(str.length()); // 随机一个下标
//            System.out.println(index);
            code += str.charAt(index); //根据下标找字符组成字符串
//            System.out.print(str.charAt(index));
        }
        System.out.println(code);
    }
}

