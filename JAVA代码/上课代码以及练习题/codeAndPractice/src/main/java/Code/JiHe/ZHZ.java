package Code.JiHe;

import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiHe
 * @文件名称：ZHZ
 * @代码功能：
 * @时间：2023/09/07/19:26
 */
public class ZHZ {
    private String name;
    private int deadTime;

    public ZHZ(String name, int deadTime) {
        this.name = name;
        this.deadTime = deadTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeadTime() {
        return deadTime;
    }

    public void setDeadTime(int deadTime) {
        this.deadTime = deadTime;
    }

    @Override
    public String toString() {
        return "ZHZ{" +
                "name='" + name + '\'' +
                ", deadTime=" + deadTime +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ZHZ zhz = (ZHZ) object;
        return deadTime == zhz.deadTime && Objects.equals(name, zhz.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, deadTime);
    }
}

