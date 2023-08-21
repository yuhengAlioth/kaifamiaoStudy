package Practice.LX0820;

import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0820
 * @文件名称：User
 * @时间：2023/08/20/23:35
 */
public class User {
    private String username; // 用户的名称
    private String password; // 用户的密码
    private String phone; // 用户登录手机号
    private int role; // 用户的身份( 1 表示管理员 2 表示普通用户)

    public User() {
    }

    public User(String username, String password, String phone, int role) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "用户名称：" + username + ", 密码：" + password + ", 手机号：" + phone + ", 身份：" + (role == 1 ? "管理员" :
                "普通用户");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && phone == user.phone
                && role == user.role;
    }

}

