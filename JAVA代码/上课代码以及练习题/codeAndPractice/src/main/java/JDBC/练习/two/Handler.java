package JDBC.练习.two;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：JDBC.练习
 * @文件名称：Handler
 * @接口功能：
 * @时间：2023/10/05/13:54
 */
@FunctionalInterface
public interface Handler<E> {

    //    E handle(Object... params);
    E handle(ResultSet set) throws SQLException;
}
