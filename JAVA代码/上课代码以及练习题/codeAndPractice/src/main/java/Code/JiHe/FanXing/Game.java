package Code.JiHe.FanXing;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.FanXing
 * @文件名称：Game
 * @代码功能：游戏泛型
 * @时间：2023/09/08/11:10
 */
public class Game implements Comparable<Game> {
    private String name;
//    private Double price;
    private double price;

    public Game(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Game o) {

        return Double.compare(price, o.price);
//        return price.compareTo(o.price);
    }
}

