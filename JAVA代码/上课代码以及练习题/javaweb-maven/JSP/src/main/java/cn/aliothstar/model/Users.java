package cn.aliothstar.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.model
 * @文件名称：Users
 * @代码功能：users表实体类
 * @时间：2023/10/25/20:12
 */
@Data
public class Users implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String email;


    @Serial
    private static final long serialVersionUID = 1L;
}

