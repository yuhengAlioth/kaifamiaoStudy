package Practice.LX0921.two;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Cilent {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动");

        Socket socket = new Socket("localhost", 7788);
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("我说：");
            String str = input.nextLine();
            out.write(str.getBytes());
            byte[] bytes = new byte[1024];
            int bytesRead = in.read(bytes);
            String msg = new String(bytes, 0, bytesRead);
            System.out.println("他说：" + msg);
        }
    }

}
