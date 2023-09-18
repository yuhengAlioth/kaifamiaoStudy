package Practice.LX0915;

import com.alibaba.fastjson2.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0915
 * @文件名称：Person
 * @代码功能：
 * @时间：2023/09/15/19:00
 */
@Data
@AllArgsConstructor // 所有字段的有参构造
@NoArgsConstructor // 无参构造
public class Person implements Serializable {

    private String name;
    private String no;
    private Person son;


/*    @Override
    public Object clone() {
        String jsonString = JSON.toJSONString(this);
        // 字符串  运行类型
        return JSON.parseObject(jsonString,Person.class);
    }*/
    @Override
    public Object clone() {
        String fileName = "io\\person.txt";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));) {
            out.writeObject(this);
            return in.readObject();
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}

