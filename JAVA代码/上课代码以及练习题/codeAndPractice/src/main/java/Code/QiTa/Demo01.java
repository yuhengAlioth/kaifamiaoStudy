package Code.QiTa;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.QiTa
 * @文件名称：Demo05
 * @时间：2023/08/12/17:32
 */
public class Demo01 {
    public static void main(String[] args) {
        // 通过位运算(异或运算)交换两个变量的值
        // 按位异或： 两个操作数相同结果是0 不同是 1
        int a = 23;
        int b = 25;
        // a ^ a = 0;
        // a ^ 0 = a;
        a = a ^ b;
        b = a ^ b;  // a ^ b ^ b = a ^ 0 = a
        a = a ^ b;  // a ^ b ^ a = 0 ^ b = b
        System.out.println(a);
        System.out.println(b);
    }
}

