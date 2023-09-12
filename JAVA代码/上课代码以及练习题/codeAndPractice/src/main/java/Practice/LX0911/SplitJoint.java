package Practice.LX0911;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0911
 * @文件名称：SplitJoint
 * @代码功能：给定一个字符串数组,使用Stream把所有字符串拼接成一个字符串
 * @时间：2023/09/11/19:09
 */
public class SplitJoint {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};

        String stream = Arrays.stream(arr).reduce("", new BinaryOperator<String>() {
            @Override
            public String apply(String string, String string2) {
                return string + string2;
            }
        });

        String stream2 = Arrays.stream(arr).reduce("",(string, string2) -> string + string2);

        String stream3 = Arrays.stream(arr).reduce((string, string2) -> string + string2).get();

        System.out.println(stream);
        System.out.println(stream2);
        System.out.println(stream3);
    }
}

