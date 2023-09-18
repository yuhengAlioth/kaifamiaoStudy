package Practice.LX0915;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSON;

import java.io.*;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0915
 * @文件名称：GameTest
 * @代码功能：并将对象转换成JSON字符串输入到文件`game.txt`中
 * @时间：2023/09/15/19:08
 */
public class GameTest {
    public static void main(String[] args) {
        Game game = new Game("永杰无间",4.9,455254,98);

        String jsonString = JSON.toJSONString(game);
        System.out.println(jsonString);

        String jsonPrettyStr = JSONUtil.toJsonPrettyStr(game);
        System.out.println(jsonPrettyStr);


        try (FileWriter fileWriter = new FileWriter("io\\game.text");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);){

            bufferedWriter.write(jsonString);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try (FileOutputStream out = new FileOutputStream("io\\game.text");) {
            out.write(jsonPrettyStr.getBytes());
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } catch (IOException e) {
            System.out.println("写出失败！");
        }

    }

}

