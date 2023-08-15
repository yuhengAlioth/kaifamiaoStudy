package Practice.LX0815;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0815
 * @文件名称：Cat
 * @时间：2023/08/15/19:31
 */
public class Cat {
    String color;
    String breed;
    public void eat(){
        System.out.println(color + "的" + breed + "正在吃鱼.....");
    }
    public void catchMouse(){
        System.out.println(color + "的" + breed + "正在逮老鼠.....");
    }
    public Cat(String color,String breed){
        this.color = color;
        this.breed = breed;
        this.eat();
        this.catchMouse();
    }
}

