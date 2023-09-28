package JDBC.学习;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC.学习
 * @文件名称：C3P0Demo
 * @代码功能：c3p0连接数据库
 * @时间：2023/09/28/14:25
 */
public class C3P0Demo {
    public static void main(String[] args) throws PropertyVetoException, SQLException {
        // 创建一个实现了 DataSource接口的实现类对象
//        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//        // 设置连接的信息
//        comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
//        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/kfm");
//        comboPooledDataSource.setUser("root");
//        comboPooledDataSource.setPassword("");
//        comboPooledDataSource.setInitialPoolSize(5);
//        Connection connection = comboPooledDataSource.getConnection();
//        System.out.println(connection);
//        PreparedStatement ps = connection.prepareStatement("select * from s_emp");
//        ResultSet set = ps.executeQuery();
//        while (set.next()) {
//            System.out.println(set.getObject("last_name"));
//        }
        // 配置文件 名字必须是 c3p0-config.xml  resources 项目根目录下
        // configName参数是 xml里面的 named-config 标签的 name 属性

        // 链接方法二
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("myc3p0");
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        PreparedStatement ps = connection.prepareStatement("select * from books");
        ResultSet set = ps.executeQuery();
        while (set.next()) {
            System.out.println(set.getObject(2));
        }

    }
}

