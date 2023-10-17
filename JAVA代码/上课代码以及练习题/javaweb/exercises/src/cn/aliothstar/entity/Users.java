package cn.aliothstar.entity;

import lombok.Data;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.entity
 * @文件名称：Users
 * @代码功能：用户列表实体类
 * @时间：2023/10/17/9:12
 */
@Data
public class Users {
    private int id;
    private String username;
    private String password;
    private String email;
}

