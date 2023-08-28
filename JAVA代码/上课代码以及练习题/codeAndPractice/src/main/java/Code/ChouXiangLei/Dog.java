package Code.ChouXiangLei;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ChouXiangLei
 * @文件名称：Dog
 * @代码功能：狗类继承自抽象类
 * @时间：2023/08/28/16:29
 */
public class Dog extends Animal{

    Dog(String name) {
        super(name);
    }

    @Override
    protected void makeSound() {
        System.out.println(super.name + "狗叫");
    }
}

