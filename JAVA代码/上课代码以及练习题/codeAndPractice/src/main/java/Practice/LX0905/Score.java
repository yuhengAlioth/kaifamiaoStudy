package Practice.LX0905;

import java.util.Objects;
import java.util.Vector;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0905
 * @文件名称：Score
 * @代码功能：成绩类
 * @时间：2023/09/05/20:06
 */
public class Score {
    static Vector vector = new Vector();

    public static void main(String[] args) {
        vector.add(66.3);
        vector.add(77.5);
        vector.add(88.2);
        vector.add(99.7);
        System.out.println(count(vector, 100, 80));
    }

    public static int count(Vector vector, double max, double min) {
        int count = 0;
        for (int i = 0; i < vector.size(); i++) {
            if ((double)(vector.get(i)) >= min && (double)(vector.get(i)) <= max) {
                count++;
            }
        }
        return count;
    }
}

