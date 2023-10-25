package cn.aliothstar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.model
 * @文件名称：KfmUser
 * @代码功能：
 * @时间：2023/10/25/15:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KfmUser {
    public KfmUser(String name) {
        this.username = name;
    }
    private Integer id; // 编号
    private String username; // 用户名
    private String name; // 姓名
    private String password; // 密码
    private String birth; // 出生日期
    private String createTime; // 账户创建时间
    private String lastLogin; // 上一次登录的时间
    private String phone; // 电话号码
    private String email; // 用户邮箱
}

