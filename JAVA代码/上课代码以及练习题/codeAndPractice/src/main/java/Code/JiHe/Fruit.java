package Code.JiHe;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0908
 * @文件名称：Fruit
 * @代码功能：水果类
 * @时间：2023/09/08/19:12
 */
public class Fruit implements Cloneable {

    private String name;
    private String color;
    private String origin; // 产地

    public Fruit(String name, String color, String origin) {
        this.name = name;
        this.color = color;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class FruitDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Fruit fruit = new Fruit("花牛苹果", "红色", "天水");
        Fruit obj = (Fruit)fruit.clone();
        System.out.println(obj);
    }
}

