package Practice.LX0905;

import java.util.Objects;
import java.util.Vector;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0905
 * @文件名称：WholeNumber
 * @代码功能：整数类
 * @时间：2023/09/05/20:04
 */
public class WholeNumber {
    static Vector vector = new Vector();
    static int count;

    public static void main(String[] args) {
        vector.add(4);
        vector.add(5);
        vector.add(4);
        vector.add(4);
        System.out.println("出现的次数为："+count(vector, count, 4));
    }

    public static int count(Vector vector, int count,int num) {
        for (int i=0;i<vector.size();i++){
            if ((int)(vector.get(i))==num){
                count++;
            }
        }
        return count;
    }
}

