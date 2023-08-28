package Code.ChouXiangLei;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ChouXiangLei
 * @文件名称：Zoo
 * @代码功能：存放动物对象里面放不同类型的叫声
 * @时间：2023/08/28/16:32
 */
public class Zoo {
    private Animal[] animals;

    Zoo(Animal[] animals) {
        this.animals = animals;
    }

    public void makeSound() {
        for (int i = 0; i < animals.length; i++) {
            animals[i].makeSound();
        }
    }

}

