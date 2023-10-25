package cn.aliothstar.service;

import cn.aliothstar.dao.UsersDao;
import cn.aliothstar.model.Users;

import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.service
 * @文件名称：UsersService
 * @代码功能：
 * @时间：2023/10/25/20:19
 */

public class UsersService {
    private UsersDao dao = new UsersDao();

    public List<Users> findAll() {
        try {
            return dao.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int delete(int id) {
        try {
            return dao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

