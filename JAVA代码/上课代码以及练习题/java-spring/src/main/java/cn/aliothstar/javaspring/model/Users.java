package cn.aliothstar.javaspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @作者：玉蘅
 * @项目名称：java-spring
 * @包名：cn.aliothstar.javaspring.model
 * @文件名称：Users
 * @代码功能：users表的实体类
 * @时间：2023/10/26/17:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String password;
    private String email;
}

