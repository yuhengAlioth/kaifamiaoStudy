package com.kfm.first.service;

import com.kfm.first.dao.StudentsDao;
import com.kfm.first.entity.Page;
import com.kfm.first.entity.Students;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final StudentsDao studentsDao = new StudentsDao();
    public Page<Students> findPage(Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 2;
        }
        try {
            List<Students> students = studentsDao.selectPage(pageNum, pageSize);
            // 当前页 每页数量 查询出来的数据
            Page<Students> page = new Page<>(pageNum, pageSize, findTotal(), students);
            return page;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public long findTotal() {
        try {
            return studentsDao.selectTotal();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
