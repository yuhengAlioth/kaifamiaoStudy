package Code.SheJiMoShi.DanLiMoShi;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.SheJiMoShi.DanLiMoShi
 * @文件名称：HungrySingleton
 * @代码功能：饿汉模式
 * @时间：2023/09/04/15:54
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){
        System.out.println("饿汉模式");
    }
    public static HungrySingleton getInstance(){
        return instance;
    }

}
class Test2{
    public static void main(String[] args) {
        HungrySingleton.getInstance();
        HungrySingleton.getInstance();
        HungrySingleton.getInstance();

    }
}
