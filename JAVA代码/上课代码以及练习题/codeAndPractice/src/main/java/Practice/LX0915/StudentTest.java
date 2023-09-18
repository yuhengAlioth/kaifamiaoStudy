package Practice.LX0915;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSON;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0915
 * @文件名称：StudentTest
 * @代码功能：请JSON文件转换成Student对象，并打印出来
 * @时间：2023/09/15/19:09
 */
public class StudentTest {
    public static void main(String[] args) {
        try(FileInputStream in = new FileInputStream("io\\student.json")) {
            byte[] bytes = in.readAllBytes();
            String s = new String(bytes);

            Student bean = JSONUtil.toBean(s, Student.class);
            System.out.println(bean);

            Student student = JSON.parseObject(s, Student.class);
            System.out.println(student);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

