package Code.JiHe.treeMap;

import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe.treeMap
 * @文件名称：Emp
 * @代码功能：
 * @时间：2023/09/11/14:25
 */
public class Emp {
    private int id;
    private String name;
    private String address;

    public Emp(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Emp emp = (Emp) object;
        return id == emp.id && Objects.equals(name, emp.name) && Objects.equals(address, emp.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }

//    @Override
//    public int compareTo(Emp o) {
//        return name.compareTo(o.name);
//
}

