package Practice.LX0915;

import com.alibaba.fastjson2.JSON;

import java.io.*;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0915
 * @文件名称：DeepCopy
 * @代码功能：分别使用JSON和序列化反序列化实现深拷贝
 * @时间：2023/09/15/19:05
 */
public class PersonTest {
    public static void main(String[] args) {

        Person person = new Person("岳山", "1001", null);
        String str = JSON.toJSONString(person);

        System.out.println(str);

        Person jsonObject = JSON.parseObject(str,Person.class);
        System.out.println(jsonObject);

        System.out.println(person.equals(jsonObject));
        System.out.println(person == jsonObject);

//        序列化反序列化实现
        xf();
    }
    public static void xf(){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("io\\xf.txt"));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream("io\\xf.txt"))
        ) {
            Person person = new Person("天海", "1002",null);

            out.writeObject(person);

            Person o =(Person) in.readObject();

            System.out.println(o);

            System.out.println(person.equals(o));
            System.out.println(person == o);

        }  catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException err) {
            throw new RuntimeException(err);
        }
    }

}

