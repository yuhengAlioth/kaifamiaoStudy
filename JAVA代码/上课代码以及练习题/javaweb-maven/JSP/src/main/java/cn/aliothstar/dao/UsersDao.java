package cn.aliothstar.dao;

import cn.aliothstar.model.Users;
import cn.aliothstar.utils.LoadDatasource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：cn.aliothstar.dao
 * @文件名称：UsersDao
 * @代码功能：操作users表增删改查
 * @时间：2023/10/25/20:13
 */

public class UsersDao {
    public List<Users> selectAll() throws Exception {
        QueryRunner queryRunner = new QueryRunner(LoadDatasource.getDatasource());
        String sql = "select * from users";
        BasicRowProcessor basicRowProcessor = new BasicRowProcessor(new GenerousBeanProcessor());
        return queryRunner.query(sql,new BeanListHandler<>(Users.class, basicRowProcessor));
    }
    public int delete(int id) throws Exception {
        QueryRunner queryRunner = new QueryRunner(LoadDatasource.getDatasource());
        String sql = "delete from users where id = ?";
        int rows = queryRunner.update(sql, new Object[]{id});
        return rows;
    }
}

