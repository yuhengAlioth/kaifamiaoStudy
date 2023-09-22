package Practice.LX0921.two;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动");

        ServerSocket server = new ServerSocket(7788);
        Socket accept = server.accept();
        InputStream in = accept.getInputStream();
        OutputStream out = accept.getOutputStream();
        Scanner input = new Scanner(System.in);
        while (true) {
            byte[] bytes = new byte[1024];
            int bytesRead = in.read(bytes);
            String msg = new String(bytes, 0, bytesRead);
            System.out.println("他说：" + msg);
            System.out.println("我说：");
            String str = input.nextLine();
            out.write(str.getBytes());
        }
    }

}