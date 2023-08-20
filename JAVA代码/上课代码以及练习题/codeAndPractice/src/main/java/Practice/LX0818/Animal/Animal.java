package Practice.LX0818.Animal;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0818.Animal
 * @文件名称：Animal
 * @时间：2023/08/18/16:21
 */
public class Animal {
    private String name;
    private String sound;

    public Animal(){
        this.sound = "动物叫声";
    }
    public void sound(String name){
        System.out.println("name: " + name + " sound: " + sound);
    }
}

