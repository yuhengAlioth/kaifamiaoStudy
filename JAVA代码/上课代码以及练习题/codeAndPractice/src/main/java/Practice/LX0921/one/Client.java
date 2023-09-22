package Practice.LX0921.one;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0921.one
 * @文件名称：Client
 * @代码功能：TPC
 * @时间：2023/09/21/21:14
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 先建立连接 确保建立连接 ok 然后再开始数据传输 连接指定主机的指定端口
        Socket socket = new Socket("localhost", 8888);

        OutputStream out = socket.getOutputStream();
        String str = "hello World";
        out.write(str.getBytes());
        out.close();
    }
}

