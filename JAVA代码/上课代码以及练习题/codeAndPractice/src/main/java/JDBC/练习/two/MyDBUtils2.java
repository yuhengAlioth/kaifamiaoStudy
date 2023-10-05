package JDBC.练习.two;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC.练习
 * @文件名称：MyDBUtils2
 * @代码功能：
 * @时间：2023/10/05/10:37
 */
public class MyDBUtils2 {
    private Connection connection = null; // 连接对象
    private PreparedStatement preparedStatement = null; // 执行对象
    private DruidDataSource dataSource = null; // 数据源

    // 每次获取连接 创建 PreparedStatement
    // 用户提供sql 这个类来执行
    public <E> List<E> select(String sql, Handler<E> handler, Object... params) throws Exception {
        getPs(sql);
        setParameter(params);
        // 解析 ResultSet --> List 集合
        ResultSet set = preparedStatement.executeQuery();
        List<E> list = new ArrayList<>();
        // 一行数据
//        Object[] objects = new Object[set.getMetaData().getColumnCount()];
        while (set.next()) {
            // 此时 set 代表一行数据  --> 就是一个 Student 对象
//            for (int i = 0; i < objects.length; i ++) {
//                objects[i] = set.getObject(i + 1);
//            }
            E handle = handler.handle(set);
//            E handle = handler.handle(objects);
            // handler.handle(objects) 相当于下面这段话
//            Student student = new Student();
//            student.setId(set.getInt("id"));
//            student.setName(set.getString("name"));
//            student.setBirth(set.getDate("birth"));
//            student.setGender(set.getString("gender"));
            list.add(handle);
//            list.add(student);
        }
        return list;
    }

    /**
     * 获取连接对象信息，创建一个连接对象
     * @throws Exception
     */
    private void getConnection() throws Exception {
        if (connection == null || connection.isClosed()){
            // 加载驱动
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            DriverManager.getConnection("");
            getDataSource();
            // 获取连接对象
            connection = dataSource.getConnection();

        }
    }

    /**
     * 数据库连接池连接数据库
     * @throws Exception
     */
    private void getDataSource() throws Exception {
        if (dataSource == null) {
            // 加载配置文件 --> Properties
            Properties prop = new Properties();
            prop.load(new FileInputStream("resources//druid.properties"));
            // 通过配置创建 DataSource
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
        }
    }

    /**
     * 将 SQL 语句中的占位符替换成具体的值
     */
    private void setParameter(Object... values) throws SQLException {
        // 替换占位符
        for (int i = 1; i <= values.length; i++) {
            preparedStatement.setObject(i, values[i - 1]);
        }
    }

    /**
     * 获取要执行的 SQL 对象
     * @param sql 预编译的SQL
     * @throws Exception
     */
    private void getPs(String sql) throws Exception {
        getConnection();
        preparedStatement = connection.prepareStatement(sql);
    }

    /**
     * 传入查询的 SQL 语句进行执行
     * @param sql
     * @param handler
     * @param params
     * @return 结果集
     * @param <E>
     * @throws Exception
     */
    public <E> E selectOne(String sql, Handler<E> handler, Object... value) throws Exception {
        List<E> select = select(sql, handler, value);
        if (select != null && select.size() > 0) {
            return select.get(0);
        }
        return null;
    }

    /**
     * 传入修改操作的 SQL 语句进行执行
     * @param sql
     * @param params
     * @return 影响行数
     * @throws Exception
     */
    public int update(String sql, Object... value) throws Exception {
        getPs(sql);
        setParameter(value);
        return preparedStatement.executeUpdate();
    }

    /**
     *关闭资源
     */
    public void close() throws SQLException {
        if (preparedStatement != null && !preparedStatement.isClosed()) {
            preparedStatement.close();
            preparedStatement = null;
        }
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
            dataSource = null;
        }
    }
}

