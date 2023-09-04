package Code.SheJiMoShi.DanLiMoShi;

import Code.ifXunHuan.If;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.SheJiMoShi.DanLiMoShi
 * @文件名称：SluggardSingleton
 * @代码功能：懒汉模式
 * @时间：2023/09/04/15:48
 */
public class SluggardSingleton {
    private static SluggardSingleton instance;

    private SluggardSingleton() {
        System.out.println("懒汉模式");
    }

    public static SluggardSingleton getInstance() {
        if (instance == null) {
            instance = new SluggardSingleton();
        }
        return instance;
    }

}

class Test {
    public static void main(String[] args) {
        SluggardSingleton a1 = SluggardSingleton.getInstance();
        SluggardSingleton a2 = SluggardSingleton.getInstance();
        SluggardSingleton.getInstance();
        System.out.println(a1 == a2);

    }
}

