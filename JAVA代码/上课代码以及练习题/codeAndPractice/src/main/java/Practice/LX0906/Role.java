package Practice.LX0906;

import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0906
 * @文件名称：Role
 * @代码功能：原神角色类
 * @时间：2023/09/06/15:14
 */
public class Role {

    private String name;
    private String property; // 属性
    private int rare; // 稀有度
    private int life; // 命座
    private int grade; // 等级

    public Role(String name, String property, int rare, int life, int grade) {
        this.name = name;
        this.property = property;
        this.rare = rare;
        this.life = life;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public int getRare() {
        return rare;
    }

    public void setRare(int rare) {
        this.rare = rare;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Role{" +
                "角色名称：'" + name + '\'' +
                ", 属性：'" + property + '\'' +
                ", 稀有度：" + rare + "星" +
                ", 命座：" + life +
                ", 等级：LV." + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return rare == role.rare && life == role.life && grade == role.grade && Objects.equals(name, role.name) && Objects.equals(property, role.property);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, property, rare, life, grade);
    }
}

