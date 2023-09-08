package Code.JiHe.FanXing;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.FanXing
 * @文件名称：Demo
 * @代码功能：
 * @时间：2023/09/08/14:22
 */
public class Demo<T> {
    private T name;
    private T price;
    public T test(T name){
        return name;
    }

    public <E> void add(E e){
        System.out.println(e + "666");
    }

}
class Test{
    public static void main(String[] args) {
        Demo<Game> gameDemo = new Demo<>();
        Game aaa = new Game("dasda", 455);
        System.out.println(gameDemo.test(aaa));
        System.out.println(gameDemo);
        gameDemo.add(aaa);
    }
}
