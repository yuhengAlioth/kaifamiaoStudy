package cn.aliothstar.javaspring.service;

import cn.aliothstar.javaspring.mapper.UsersMapper;
import cn.aliothstar.javaspring.model.Users;

import java.sql.SQLException;

/**
 * @作者：玉蘅
 * @项目名称：java-spring
 * @包名：cn.aliothstar.javaspring.service
 * @文件名称：UsersService
 * @代码功能：处理用户业务
 * @时间：2023/10/26/17:24
 */

public class UsersService {
    private UsersMapper usersMapper = new UsersMapper();


    /**
     * 用户登录验证
     * @param username 输入的用户名
     * @param password 输入的密码
     * @return 查询到的用户对象
     */
    public Users login(String username, String password) {
        if (username == null || password == null) {
            return null;
        }
        // 访问数据库是否存在该用户
        try {
            return usersMapper.selectByUsernameAndPassword(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

