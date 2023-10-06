package Code.reflect;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.reflect
 * @文件名称：MyInterface
 * @接口功能：
 * @时间：2023/10/06/15:40
 */
public interface MyInterface {
    default void test () {
        System.out.println("test");
    }
}

