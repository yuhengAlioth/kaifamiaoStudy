package Code.MeiJu;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.MeiJu
 * @文件名称：Test
 * @代码功能：测试枚举
 * @时间：2023/09/04/11:39
 */
public class Test {
    public static void main(String[] args) {
        Car one = Car.FLL;
        System.out.println(one.getName());
        System.out.println(one.getColor());
        one.setColor("彩色");
        System.out.println(one.getColor());
    }

}

