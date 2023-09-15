package Practice.LX0914;

import java.io.*;
import java.util.*;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0914
 * @文件名称：ChuShiBiao
 * @代码功能：一段文字按照正常的顺序写到一个新的文件中
 * @时间：2023/09/14/19:23
 */
public class ChuShiBiao {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();

        try(FileReader fileReader = new FileReader("D:\\桌面\\csb.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("D:\\桌面\\出师表.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            String line = ""; // 读一行文本
            while ((line = bufferedReader.readLine()) != null) {
                String modifiedLine = line.replace("。","。\n");
                stringList.add(modifiedLine);
            }
            //排序
            stringList.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int i1 = Integer.parseInt(o1.split("\\.")[0]);
                    int i2 = Integer.parseInt(o2.split("\\.")[0]);
                    return i1 - i2;
                }
            });

//            Collections.sort(stringList); // 自然排序

            for (String s : stringList) {
//                System.out.println(s);
                bufferedWriter.write(s);
                bufferedWriter.newLine(); // 换行
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

