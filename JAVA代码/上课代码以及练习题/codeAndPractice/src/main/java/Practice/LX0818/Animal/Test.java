package Practice.LX0818.Animal;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0818.Animal
 * @文件名称：Test
 * @时间：2023/08/18/16:34
 */
public class Test {
    public static void main(String[] args) {
        Animal animal = null;
        animal = new Animal();
        animal.sound("鹅");
        animal = new Dog();
        animal.sound("金毛");
    }
}

