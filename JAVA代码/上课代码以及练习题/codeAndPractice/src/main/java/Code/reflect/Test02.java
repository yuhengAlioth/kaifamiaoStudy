package Code.reflect;

import java.lang.reflect.Field;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.reflect
 * @文件名称：Test02
 * @代码功能：
 * @时间：2023/10/06/15:08
 */
public class Test02 {
    public void saveObject(Object obj) {
        // TODO 将对象的信息打印出来
        System.out.println(obj);
        Class<?> aClass = obj.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
//            declaredField.getName()
//            declaredField.get(obj)
        }
        // name == ""
        // age == 12
        //

    }
}

