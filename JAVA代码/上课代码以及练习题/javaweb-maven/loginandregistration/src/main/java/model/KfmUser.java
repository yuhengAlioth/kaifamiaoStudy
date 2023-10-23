package model;

import lombok.Data;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：model
 * @文件名称：KfmUser
 * @代码功能：数据库kfm_user表的实体类
 * @时间：2023/10/21/9:20
 */
@Data
public class KfmUser {
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

