package Code.网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.网络编程
 * @文件名称：UDPSever
 * @代码功能：服务器
 * @时间：2023/09/21/14:52
 */
public class UDPSever {
    public static void main(String[] args) {
        System.out.println("服务端启动");
        Scanner input = new Scanner(System.in);
        try {
            // 服务端启动的端口
            DatagramSocket socket = new DatagramSocket(8888);
            while (true){
                byte[] buffer = new byte[1024 * 64];
                DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
                try {
                    // 接收到的消息保存在packet中
                    socket.receive(packet);
                } catch (IOException e) {
                    System.out.println("服务器出错了");
                    break;
                }
                int len = packet.getLength();
                String message = new String(buffer,0,len);
                System.out.println("接收到来自：" + packet.getAddress().getHostAddress() + " 发送的消息：" + message);

                System.out.println("===========");

                System.out.println("你说：");
                String msg = input.next();
                byte[] bytes = msg.getBytes();
                DatagramPacket packet2 = new DatagramPacket(bytes,0,bytes.length, packet.getAddress(),packet.getPort());
                socket.send(packet2); // 发送数据
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

