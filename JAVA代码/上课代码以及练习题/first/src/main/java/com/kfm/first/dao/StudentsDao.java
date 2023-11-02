package com.kfm.first.dao;

import com.kfm.first.entity.Students;
import com.kfm.first.utils.ConnectMysql;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentsDao {
    public List<Students> selectAll() {
        QueryRunner queryRunner = ConnectMysql.queryRunner();
        //开启下划线->驼峰转换所用
        BeanProcessor bean = new GenerousBeanProcessor();
        RowProcessor processor = new BasicRowProcessor(bean);
        String sql = "select * from students";
        try {
            return queryRunner.query(sql, new BeanListHandler<>(Students.class, processor));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Students> selectAll(int page, int pageSize) {
        QueryRunner queryRunner = ConnectMysql.queryRunner();
        //开启下划线->驼峰转换所用
        BeanProcessor bean = new GenerousBeanProcessor();
        RowProcessor processor = new BasicRowProcessor(bean);
        String sql = "select * from students LIMIT " + (page - 1) * pageSize + "," + pageSize;
        try {
            return queryRunner.query(sql, new BeanListHandler<>(Students.class, processor));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 分页查询
     *
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return 分页后的数据
     */
//    public List<Students> selectPage(int pageNum, int pageSize) throws SQLException {
    public List<Students> selectPage(int pageNum, int pageSize, Students student) throws SQLException {
        QueryRunner queryRunner = ConnectMysql.queryRunner();
        //开启下划线->驼峰转换所用
        BeanProcessor bean = new GenerousBeanProcessor();
        RowProcessor processor = new BasicRowProcessor(bean);
//        String sql = "select * from students limit ?, ?";
//        return queryRunner.query(sql, new BeanListHandler<>(Students.class, processor), (pageNum - 1) * pageSize, pageSize);
        StringBuilder sql = new StringBuilder("select * from students");
        StringBuilder condition = new StringBuilder();
        List<Object> params = new ArrayList<>();
        if (student.getId() != null) {
            condition.append(" where id = ? ");
            params.add(student.getId());
        }
        if (student.getName() != null && !student.getName().isEmpty()) {
            if (condition.isEmpty()) {
                condition.append(" where name = ? ");
            } else {
                condition.append(" and name = ?");
            }
            params.add(student.getName());
        }
        if (student.getAge() != null) {
            if (condition.isEmpty()) {
                condition.append(" where age = ? ");
            } else {
                condition.append(" and age = ?");
            }
            params.add(student.getAge());
        }
        if (!condition.isEmpty()) {
            sql.append(condition);
        }
        System.out.println(sql.toString());
        sql.append(" limit ?,? ");
        params.add((pageNum - 1) * pageSize);
        params.add(pageSize);
        return queryRunner.query(sql.toString(), new BeanListHandler<>(Students.class, processor), params.toArray());
    }

    //    public long selectTotal() throws SQLException {
//        QueryRunner queryRunner = ConnectMysql.queryRunner();
//        String sql = "select count(*) from students";
//        return queryRunner.query(sql, new ScalarHandler<>());
//    }
    public long selectTotal(Students student) throws SQLException {
        QueryRunner queryRunner = ConnectMysql.queryRunner();
        StringBuilder sql = new StringBuilder("select count(*) from students");
        StringBuilder condition = new StringBuilder();
        List<Object> params = new ArrayList<>();
        if (student.getId() != null) {
            condition.append(" where id = ? ");
            params.add(student.getId());
        }
        if (student.getName() != null && !student.getName().isEmpty()) {
            if (condition.isEmpty()) {
                condition.append(" where name = ? ");
            } else {
                condition.append(" and name = ?");
            }
            params.add(student.getName());
        }
        if (student.getAge() != null) {
            if (condition.isEmpty()) {
                condition.append(" where age = ? ");
            } else {
                condition.append(" and age = ?");
            }
            params.add(student.getAge());
        }
        if (!condition.isEmpty()) {
            sql.append(condition);
        }
        System.out.println(sql.toString());
        return queryRunner.query(sql.toString(), new ScalarHandler<>(), params.toArray());
    }
    // 为了避免写n个方法
    // 拼接SQL
    public List<Students> selectByStudent(Students student) throws SQLException {
        QueryRunner queryRunner = ConnectMysql.queryRunner();
        //开启下划线->驼峰转换所用
        BeanProcessor bean = new GenerousBeanProcessor();
        RowProcessor processor = new BasicRowProcessor(bean);
        StringBuilder sql = new StringBuilder("select * from students");
        StringBuilder condition = new StringBuilder();
        List<Object> params = new ArrayList<>();
        if (student.getId() != null) {
            condition.append(" where id = ? ");
            params.add(student.getId());
        }

        if (student.getName() != null && !student.getName().isEmpty()) {
            if (condition.isEmpty()) {
                condition.append(" where name = ? ");
            } else {
                condition.append(" and name = ?");
            }
            params.add(student.getName());
        }
        if (student.getAge() != null) {
            if (condition.isEmpty()) {
                condition.append(" where age = ? ");
            } else {
                condition.append(" and age = ?");
            }
            params.add(student.getAge());
        }
        if (!condition.isEmpty()) {
            sql.append(condition);
        }
        System.out.println(sql.toString());
        return queryRunner.query(sql.toString(), new BeanListHandler<>(Students.class, processor), params.toArray());
    }


    public Students login(String username, String password) {
        QueryRunner queryRunner = ConnectMysql.queryRunner();
        //开启下划线->驼峰转换所用
        BeanProcessor bean = new GenerousBeanProcessor();
        RowProcessor processor = new BasicRowProcessor(bean);
        String sql = "select * from students where user_name=? and password = ?";
        try {
            return queryRunner.query(sql, new BeanHandler<>(Students.class, processor), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int delete(int id) {
        QueryRunner queryRunner = ConnectMysql.queryRunner();
        String sql = "delete from students where id = ?";
        try {
            return queryRunner.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Students selectOne(int id) {
        QueryRunner queryRunner = ConnectMysql.queryRunner();
        //开启下划线->驼峰转换所用
        BeanProcessor bean = new GenerousBeanProcessor();
        RowProcessor processor = new BasicRowProcessor(bean);
        String sql = "select * from students where id = ?";
        try {
            return queryRunner.query(sql, new BeanHandler<>(Students.class, processor), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int modify(String username, String password, String name, int age, int id) {
        QueryRunner queryRunner = ConnectMysql.queryRunner();
        String sql = "update students set user_name = ? ,password = ? ,name = ?,age = ? where id = ?";
        try {
            return queryRunner.update(sql, username, password, name, age, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int addUser(String username, String password, String name, int age) {
        QueryRunner queryRunner = ConnectMysql.queryRunner();
        String sql = "insert into students (user_name,password,name,age) values (?,?,?,?)";
        try {
            return queryRunner.update(sql, username, password, name, age);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
