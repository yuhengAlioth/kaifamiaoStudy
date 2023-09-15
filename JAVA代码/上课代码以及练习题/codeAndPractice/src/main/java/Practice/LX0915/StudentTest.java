package Practice.LX0915;

import com.alibaba.fastjson2.JSON;

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
        String string = """
                {
                	"id" : 1,
                    "name" : "枫原万叶",
                    "age" : 20,
                    "password" : "123456",
                    "hobby" : ["唱歌", "游戏", "学习"]
                }
                """;
        Student student = JSON.parseObject(string,Student.class);
        System.out.println(student);
    }

}

