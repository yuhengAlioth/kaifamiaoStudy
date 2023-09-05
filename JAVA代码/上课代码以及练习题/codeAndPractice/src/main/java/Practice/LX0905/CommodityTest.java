package Practice.LX0905;

import java.util.Vector;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0905
 * @文件名称：CommodityTest
 * @代码功能：测试
 * @时间：2023/09/05/20:34
 */
public class CommodityTest {
    static Vector vector = new Vector<Commodity>();
    public static void main(String[] args) {

//        vector.add(56);
//        vector.add(65);

        vector.add(new Commodity(32.2,"长枪"));
        vector.add(new Commodity(68,"火炮"));

        System.out.println("数组长度：" + vector.size());
        avg(vector);
    }
    public static void avg(Vector<Commodity> vector){
        double sum = 0;
        int size = vector.size();

        for (Commodity o : vector) {
            sum += o.price;
//            System.out.println(o.price);
        }
        System.out.println(sum);
        System.out.println(sum / size);
    }

}

