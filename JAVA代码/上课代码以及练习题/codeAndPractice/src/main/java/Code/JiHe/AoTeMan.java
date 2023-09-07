package Code.JiHe;

import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe
 * @文件名称：AoTeMan
 * @代码功能：奥特曼类
 * @时间：2023/09/07/19:24
 */
public class AoTeMan implements Comparable {
    private String name;
    private int age;
    private int height;

    public AoTeMan(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "AoTeMan{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AoTeMan aoTeMan = (AoTeMan) object;
        return age == aoTeMan.age && height == aoTeMan.height && Objects.equals(name, aoTeMan.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height);
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
        if (o instanceof AoTeMan aoTeMan) {
            return age - aoTeMan.age > 0 ? 1 : -1;
        }
        throw new ClassCastException();
    }
}

