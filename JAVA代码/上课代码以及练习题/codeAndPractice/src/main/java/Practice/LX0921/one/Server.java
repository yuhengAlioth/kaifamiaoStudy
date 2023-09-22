package Practice.LX0921.one;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0921.one
 * @文件名称：Server
 * @代码功能：
 * @时间：2023/09/21/21:14
 */
public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);
        Socket accept = serverSocket.accept(); // 获取与客户端建立连接的对象
        System.out.println(accept);
        InputStream in = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int read = 0;
        String str = "";
        while ((read = in.read(bytes)) != -1) {
            str += new String(bytes, 0, read);
        }
        System.out.println(accept.getInetAddress().getHostAddress());
        System.out.println(str);
        accept.close();
        in.close();
    }
}

