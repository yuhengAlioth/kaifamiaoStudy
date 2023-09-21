package Code.网络编程;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.网络编程
 * @文件名称：UDSocket
 * @代码功能：客户端
 * @时间：2023/09/21/14:43
 */
public class UDSocket {
    public static void main(String[] args) {
        System.out.println("客户端启动");
        Scanner input = new Scanner(System.in);

        try {
            // 客户端启动的端口
            DatagramSocket socket = new DatagramSocket(8899);
            // 输入exit退出
            while (true){
                System.out.println("你说：");
                String msg = input.next();
                if ("exit".equals(msg)){
                    socket.close();
                    System.out.println("退出客户端");
                    break;
                }
                // 将获取的数据放进数组中
                byte[] bytes = msg.getBytes();
                // 要发送的主机地址
//                InetAddress address = InetAddress.getByName("10.0.3.114");
                InetAddress address = InetAddress.getByName("10.0.3.9");
//                InetAddress address = InetAddress.getByName("10.0.3.184");
//                InetAddress address = InetAddress.getByName("10.0.3.154");
//                InetAddress address = InetAddress.getByName("localhost");
                DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,address,8888);
                socket.send(packet); // 发送数据

                System.out.println("======");

                byte[] buffer = new byte[1024 * 64];
                DatagramPacket packet2 = new DatagramPacket(buffer,0,buffer.length);
                try {
                    // 接收到的消息保存在packet中
                    socket.receive(packet2);
                } catch (IOException e) {
                    System.out.println("服务器出错了");
                    break;
                }
                int len = packet2.getLength();
                String message = new String(buffer,0,len);
                System.out.println(packet2.getAddress().getHostAddress() + " 回复：" + message);
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

