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
        Person clone = (Person) person.clone();
        System.out.println(clone.getSon());
        System.out.println(person.getSon() == clone.getSon());

    }

}

