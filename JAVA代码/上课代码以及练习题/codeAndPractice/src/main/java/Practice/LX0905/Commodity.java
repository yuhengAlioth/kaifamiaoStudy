package Practice.LX0905;

import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0905
 * @文件名称：Commodity
 * @代码功能：商品类
 * @时间：2023/09/05/20:01
 */
public class Commodity {
    public double price;
    public String name;

    public Commodity() {

    }
    public Commodity(double price, String name) {
        this.price = price;
        this.name = name;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return Double.compare(price, commodity.price) == 0 && Objects.equals(name, commodity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }
}

