package Practice.LX0907;


import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0907
 * @文件名称：Card
 * @代码功能：扑克牌类
 * @时间：2023/09/07/19:29
 */
public class Card implements Comparable {
    private String number;
    private String color;
    // 斗地主扑克牌 大小顺序
    // 3 4 5 6 7 8 9 10 J Q K A 2 小王 大王
    private int size;

    public Card(String number, String color, int size) {
        this.number = number;
        this.color = color;
        this.size = size;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
//        + "牌的大小：" + size
        return number + ' '+ color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return size == card.size && Objects.equals(number, card.number) && Objects.equals(color, card.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, color, size);
    }
    @Override
    public int compareTo(Object o) {
        // this 谁调用的此方法，this就是谁
        if (this.equals(o)) {
            return 0;
        }
        if (o == null) {
            throw new NullPointerException();
        }
        if (o instanceof Card card) {
            return size - card.size < 0 ? 1 : -1;
        }
        throw new ClassCastException();
    }
}

