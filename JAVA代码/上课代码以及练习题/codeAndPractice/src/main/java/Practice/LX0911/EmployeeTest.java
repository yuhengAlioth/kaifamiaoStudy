package Practice.LX0911;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0911
 * @文件名称：EmployeeTest
 * @代码功能：请通过Stream对多个Employee对象按salary排序,然后取前3个输出
 * @时间：2023/09/11/20:15
 */
public class EmployeeTest {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Collections.addAll(employeeList,new Employee("张三",25,5236.5),
                new Employee("李斯",25,3000),
                new Employee("王无",25,2926.5),
                new Employee("约瑟翰",25,1943),
                new Employee("太平洋",25,562));

        Stream<Employee> employeeStream = employeeList.stream();
        employeeStream.sorted().limit(3).forEach(new Consumer<Employee>() {
            @Override
            public void accept(Employee employee) {
                System.out.println(employee);
            }
        });

    }

}

