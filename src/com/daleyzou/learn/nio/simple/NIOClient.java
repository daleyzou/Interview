package com.daleyzou.learn.nio.simple;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: DaleyZou
 * @Description: 套接字nio客户端
 * @Date: Created in 10:29 2018-10-19
 * @Modified By:
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        String str1 = "Hello World str1!";
        String str2 = "Hello World str2!";
        out.write(str2.getBytes());
        out.close();
    }
}
