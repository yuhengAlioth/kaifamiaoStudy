package Practice.LX0824.Marry;

import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0824
 * @文件名称：JiHun
 * @时间：2023/08/24/19:12
 */
public class Person {
    private String name;
    private Character gender;
    private Integer age;
    private Boolean isMarry;
    private Person[] peoples; // 储存人的信息
    private int peopleCount; // 记录存放人信息的数组下标

    public Person() {
        peoples = new Person[2]; // 初始化数组
        peopleCount = 0;
    }

    public Person(String name, Character gender, Integer age, Boolean isMarry) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.isMarry = isMarry;
    }

    /**
     * 扩容储存人信息的数组
     */
    private void peopleGrow() {
        if (peopleCount == peoples.length) {
            Person[] newPeople = new Person[peoples.length * 2];
            System.arraycopy(peoples, 0, newPeople, 0, peoples.length);
            peoples = newPeople;
        }
    }

    /**
     * 新增一个人
     *
     * @param people
     */
    public void addPeople(Person people) {
        peopleGrow();
        peoples[peopleCount] = people;
        peopleCount++;
    }

    /**
     * 查询输入信息
     */
    public void showAll() {
        for (int i = 0; i < peopleCount; i++) {
            System.out.println(peoples[i]);
        }
    }

    /**
     * 判断是否可以结婚
     */
    public boolean isMarry(){
        boolean a = peoples[0].getAge() >= 22
                && peoples[0].getGender().equals('男')
                && peoples[0].getMarry() == false;
        boolean b = peoples[0].getAge() >= 20
                && peoples[0].getGender().equals('女')
                && peoples[0].getMarry() == false;
        boolean c = peoples[1].getAge() >= 22
                && peoples[1].getGender().equals('男')
                && peoples[1].getMarry() == false;
        boolean d = peoples[1].getAge() >= 20
                && peoples[1].getGender().equals('女')
                && peoples[1].getMarry() == false;
        if ((a || b) && (c || d)){
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getMarry() {
        return isMarry;
    }

    public void setMarry(Boolean marry) {
        isMarry = marry;
    }


    @Override
    public String toString() {
        return "Person{" +
                "姓名：'" + name + '\'' +
                ", 性别：" + gender +
                ", 年龄：" + age +
                ", 是否结婚：" + isMarry +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(gender, person.gender) && Objects.equals(age, person.age) && Objects.equals(isMarry, person.isMarry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age, isMarry);
    }
}

