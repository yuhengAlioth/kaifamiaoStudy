package cn.aliothstar.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.model
 * @文件名称：Users
 * @代码功能：数据库表users的实体类
 * @时间：2023/10/20/17:56
 */
@Data
public class Users implements Serializable {

    private Integer id;
    private String name;
    private String password;
    private String email;
}

