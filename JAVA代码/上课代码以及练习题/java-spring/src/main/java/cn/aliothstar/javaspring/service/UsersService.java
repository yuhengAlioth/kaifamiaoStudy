package cn.aliothstar.javaspring.service;

import cn.aliothstar.javaspring.mapper.UsersMapper;
import cn.aliothstar.javaspring.model.Users;
import cn.hutool.crypto.SecureUtil;

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
            return usersMapper.selectByUsernameAndPassword(username,SecureUtil.md5(password));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     * @param email 邮箱
     * @return 1-注册成功
     */
    public int register(String username, String password, String email) {
        // 对密码进行加密
        String s = SecureUtil.md5(password);
        try {
            return usersMapper.insertUsers(username, s, email);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

