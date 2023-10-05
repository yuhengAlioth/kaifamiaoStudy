package JDBC.学习;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC.学习
 * @文件名称：DruidDemo
 * @代码功能：德鲁伊数据库连接池
 * @时间：2023/09/28/10:22
 */
public class DruidDemo {
    public static void main(String[] args) {
        try {
            // 加载配置文件
            Properties prop = new Properties();
            prop.load(new FileInputStream("resources//druid.properties"));
            // 通过配置创建
            DataSource ds = DruidDataSourceFactory.createDataSource(prop);
            // 获取连接对象
            Connection conn = ds.getConnection();
            System.out.println(conn);
            // 获取执行sql的对象
            PreparedStatement statement = conn.prepareStatement("select * from books");
            // 执行sql
            ResultSet set = statement.executeQuery();
            ResultSetMetaData metaData = set.getMetaData();
            int count = metaData.getColumnCount();
            while (set.next()){
                for (int i = 1; i <= count; i++) {
                    System.out.println(set.getObject(i) + " ");
                }
            }
            set.close();
            statement.close();
            conn.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

