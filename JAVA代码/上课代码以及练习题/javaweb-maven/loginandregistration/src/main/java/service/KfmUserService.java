package service;

import mapper.KfmUserMapper;
import model.KfmUser;

import java.sql.SQLException;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：service
 * @文件名称：UserService
 * @代码功能：处理用户的所有业务
 * @时间：2023/10/21/9:38
 */

public class KfmUserService {
    private KfmUserMapper kfmUserMapper = new KfmUserMapper();

    /**
     * 用户登录验证
     * @param username 输入的用户名
     * @param password 输入的密码
     * @return 查询到的用户对象
     */
    public KfmUser login(String username, String password,String loginTime) {
        if (username == null || password == null) {
            return null;
        }
        // 访问数据库是否存在该用户
        try {
            kfmUserMapper.updateLoginTime(loginTime,username);
            return kfmUserMapper.selectByUsernameAndPassword(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}

