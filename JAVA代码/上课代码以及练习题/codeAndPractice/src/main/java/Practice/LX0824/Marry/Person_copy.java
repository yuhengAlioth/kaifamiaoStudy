package Practice.LX0824.Marry;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0824.Marry
 * @文件名称：Person_copy
 * @代码功能：人
 * @时间：2023/08/24/22:20
 */
public class Person_copy {
    private String name;
    private Character gender;
    private Integer age;
    private Boolean isMarry;

    public Person_copy() {
    }

    public Person_copy(String name, Character gender, Integer age, Boolean isMarry) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.isMarry = isMarry;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return gender
     */
    public Character getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(Character gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     * @return isMarry
     */
    public Boolean getIsMarry() {
        return isMarry;
    }

    /**
     * 设置
     * @param isMarry
     */
    public void setIsMarry(Boolean isMarry) {
        this.isMarry = isMarry;
    }

    public String toString() {
        return "Person_copy{name = " + name + ", gender = " + gender + ", age = " + age + ", isMarry = " + isMarry + "}";
    }
}

