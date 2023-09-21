package Code.网络编程;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.网络编程
 * @文件名称：Test
 * @代码功能：
 * @时间：2023/09/21/14:24
 */
public class Test {
    public static void main(String[] args) {
        InetAddress address = null;
        try {
            // 通过主机地址获取对应的 InetAddress 对象
            address = InetAddress.getByName("www.baidu.com");
            System.out.println(address.getCanonicalHostName());
            System.out.println(Arrays.toString(address.getAddress()));
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName()); // 主机地址

            System.out.println(address.isReachable(20000));
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(address);
    }
}

