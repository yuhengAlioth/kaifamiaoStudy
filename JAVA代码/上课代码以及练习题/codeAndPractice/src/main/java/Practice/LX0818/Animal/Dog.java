package Practice.LX0818.Animal;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0818.Animal
 * @文件名称：Dog
 * @时间：2023/08/18/16:26
 */
public class Dog extends Animal{
    private String sound;
    public Dog(){
        this.sound = "汪汪汪";
    }
    @Override
    public void sound(String name) {
        System.out.println("name: " + name + " sound: " + sound);
    }
}

