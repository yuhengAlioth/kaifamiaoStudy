package Practice.LX0815;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0815
 * @文件名称：Dog
 * @时间：2023/08/15/19:43
 */
public class Dog {
    String color;
    String breed;
    public void eat(){
        System.out.println(color + "的" + breed + "正在啃骨头.....");
    }
    public void lookHouse(){
        System.out.println(color + "的" + breed + "正在看家.....");
    }
    public Dog(String color,String breed){
        this.color = color;
        this.breed = breed;
        this.eat();
        this.lookHouse();
    }
}

