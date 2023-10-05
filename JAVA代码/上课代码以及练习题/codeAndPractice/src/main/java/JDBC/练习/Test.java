package JDBC.练习;

import JDBC.练习.two.Student;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC.练习
 * @文件名称：Test
 * @代码功能：DBUtils的jar包使用
 * @时间：2023/10/05/14:43
 */
public class Test {
    public static void main(String[] args) throws Exception {
        DbUtils dbUtils = new DbUtils();
        // 创建了一个 QueryRunner 对象，并传递一个 DataSource 如何创建连接在底层已经实现
        QueryRunner queryRunner = new QueryRunner(getDataSource());
        String sql = "update student set name = ? where id = ?";
        int update = queryRunner.update(sql, "天海", 4);
        System.out.println(update);

        String select = "select * from student";

        // new Student().getClass(); 字节码对象
        // ArrayHandler --> 第一行数据 --> Object 数组中
        Object[] query = queryRunner.query(select, new ArrayHandler());
        System.out.println(Arrays.toString(query));
        System.out.println("==========");

        // ArrayListHandler --> 每一行数据 --> Object 数组中，最后放到 List 集合中
        List<Object[]> query1 = queryRunner.query(select, new ArrayListHandler());
        query1.forEach(obj -> {
            System.out.println(Arrays.toString(obj));
        });
        System.out.println("==========");

        // BeanHandler --> 第一行数据 --> 对象
        Student stu = queryRunner.query(select, new BeanHandler<>(Student.class));
        System.out.println(stu);
        System.out.println("==========");

        // BeanListHandler --> 每一行数据 --> 对象 将对象放到 List 集合中
        List<Student> query2 = queryRunner.query(select, new BeanListHandler<>(Student.class));
        query2.forEach(obj -> System.out.println(obj));
        System.out.println("==========");

        // ColumnListHandler --> 将某一列取出来放到 List 集合中
        List<Object> ids = queryRunner.query(select, new ColumnListHandler<>(2));
        System.out.println(ids);
        System.out.println("==========");

        // MapHandler --> 将第一行数据 列名当做 key 列内容 当做value 放到 Map 集合中
        Map<String, Object> map = queryRunner.query(select, new MapHandler());
        map.forEach((k, v) -> {
            System.out.println("key：" + k + " ==> " + "value：" + v);
        });
        System.out.println("==========");

        // MapListHandler 将每一行的数据 列名当 key 列内容 当 value 放到 Map 集合中，最后放到 List 集合中
        List<Map<String, Object>> query3 = queryRunner.query(select, new MapListHandler());
        query3.forEach(obj -> {
            obj.forEach((k,v) -> {
                System.out.println("key：" + k + " ==> " + "value：" + v);
            });
        });
        System.out.println("==========");

        // KeyedHandler 每一行的数据 列名 作为 key  列内容作为value 封装成 Map1对象 在将结果放到新的Map2对象，key是执行的列的值 value就是Map1对象
        Map<String, Map<String, Object>> mapMap = queryRunner.query(select, new KeyedHandler<String>("name"));
        mapMap.forEach((k, v) -> {
            System.out.println("key：" + k + " ==> " + "value：" + v);
        });
        System.out.println("==========");

        sql = "select name from student where id = ?";
        // ScalarHandler 查询只有一行一列的结果 用这个实现类
        String query4 = queryRunner.query(sql, new ScalarHandler<String>(1), 1);
        System.out.println(query4);
    }

    private static DataSource getDataSource() throws Exception {
        // 加载配置文件 --> Properties
        Properties prop = new Properties();
        prop.load(new FileInputStream("resources/druid.properties"));
        // 通过配置创建 DataSource
        return DruidDataSourceFactory.createDataSource(prop);
    }
}

