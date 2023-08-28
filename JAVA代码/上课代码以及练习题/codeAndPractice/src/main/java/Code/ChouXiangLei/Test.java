package Code.ChouXiangLei;

import Practice.LX0815.Cat;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ChouXiangLei
 * @文件名称：Test
 * @代码功能：测试类
 * @时间：2023/08/28/17:03
 */
public class Test {
    public static void main(String[] args) {
        // Animal a1 = new Dog("汪汪特工队");
        // Animal[] animals = {a1, }
        Animal[] animals = {new Dog("柯基")};
        Zoo zoo = new Zoo(animals);
        zoo.makeSound();
    }

}

