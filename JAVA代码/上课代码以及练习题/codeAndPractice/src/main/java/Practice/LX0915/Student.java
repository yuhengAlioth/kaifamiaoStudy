package Practice.LX0915;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0915
 * @文件名称：Student
 * @代码功能：
 * @时间：2023/09/15/19:09
 */
@Data
@AllArgsConstructor // 所有字段的有参构造
@NoArgsConstructor // 无参构造
public class Student {

    private int id;
    private String name;
    private int age;
    private String password;
    private String[] hobby;

}

