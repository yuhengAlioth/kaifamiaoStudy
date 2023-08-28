package Code.ChouXiangLei;

import javax.lang.model.element.Name;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ChouXiangLei
 * @文件名称：Animal
 * @代码功能：抽象动物类
 * @时间：2023/08/28/16:27
 */
public abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    protected abstract void makeSound();
}

