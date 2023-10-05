package Code.reflect;

import java.util.Date;
import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.反射
 * @文件名称：Student
 * @代码功能：学生类
 * @时间：2023/10/05/17:04
 */
public class Student {
    private int id;
    private String name;
    private Date birth;

    public Student() {}

    public Student(int id) {
        this.id = id;
    }

    public Student(String name){
        this.name = name;
    }

    private Student(String name, Date birth) {
        this.name = name;
        this.birth = birth;
    }

    public Student(int id, String name, Date birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(birth, student.birth) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, birth, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", birth=" + birth +
                ", name='" + name + '\'' +
                '}';
    }
}

