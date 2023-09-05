package Code.JiHe;

import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe
 * @文件名称：YongJieWuJian
 * @代码功能：永劫无间英雄类
 * @时间：2023/09/05/11:21
 */
public class YongJieWuJian {
    private String name;
    private int age;
    private String place; // 出生地
    private String standing; // 身份
    private String hobby; // 爱好
    private String CV; // 配音演员

    public YongJieWuJian(String name, int age, String place, String standing, String hobby, String CV) {
        this.name = name;
        this.age = age;
        this.place = place;
        this.standing = standing;
        this.hobby = hobby;
        this.CV = CV;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStanding() {
        return standing;
    }

    public void setStanding(String standing) {
        this.standing = standing;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }

    @Override
    public String toString() {
        return "永劫无间英雄介绍：{" +
                "姓名：'" + name + '\'' +
                ", 年龄：" + age +
                ", 出生地：'" + place + '\'' +
                ", 身份：'" + standing + '\'' +
                ", 爱好：'" + hobby + '\'' +
                ", 配音员：'" + CV + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YongJieWuJian that = (YongJieWuJian) o;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(place, that.place) && Objects.equals(standing, that.standing) && Objects.equals(hobby, that.hobby) && Objects.equals(CV, that.CV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, place, standing, hobby, CV);
    }
}

