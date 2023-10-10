package Code.reflect;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.reflect
 * @文件名称：Game
 * @代码功能：
 * @时间：2023/10/06/10:15
 */
public class Game {
    private String name;
    private int star;
    private double money;

    private GenericClass<Student, Game, String> genericClass;

    public String country = "China";

    String people;
    protected int code;
    private String syntheticField;

    private List<String> heroes;
    private Map<String, Integer> map;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Game() {
    }

    public double play(double hours) throws ClassNotFoundException, IOException {
        System.out.println("play" + hours);
        return 0.0;
    }

    public void test(Object... objects) {

    }

    public synchronized double play(double hours, int numbers) {
        System.out.println("play" + hours);
        return 0.0;
    }

    private void makeMoney(double money) {
        System.out.println(name + "makeMoney" + money);
    }

    public void rank() {
        System.out.println("rank");
    }

    private void team() {
        System.out.println("team");
    }


    public Game(String name) {
        this.name = name;
    }

    private Game(String name, int star, double money) {
        this.name = name;
        this.star = star;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", star=" + star +
                ", money=" + money +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }


    public Game clone() {
        return null;
    }
}

