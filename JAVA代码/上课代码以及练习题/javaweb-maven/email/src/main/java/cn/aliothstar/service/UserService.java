package cn.aliothstar.service;

import cn.aliothstar.mapper.UsersMapper;
import cn.aliothstar.model.Users;

import java.sql.SQLException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.service
 * @文件名称：UserService
 * @代码功能：处理用户的所有业务逻辑
 * @时间：2023/10/20/17:58
 */

public class UserService {
    private UsersMapper usersMapper = new UsersMapper();

    public Users login(String username, String password) {
        if (username == null || password == null) {
            return null;
        }
        // 去数据访问层查询是否存在这样的一个用户
        try {
            return usersMapper.selectByUsernameAndPassword(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

