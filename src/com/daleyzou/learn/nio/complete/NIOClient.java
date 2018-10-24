package com.daleyzou.learn.nio.complete;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Author: DaleyZou
 * @Description: NIO客户端
 * @Date: Created in 11:20 2018-10-19
 * @Modified By:
 */
public class NIOClient {
    // 通道管理器
    private Selector selector;

    /**
     * @Description: 获得一个Socket通道，并对该通道做一些初始化的工作
     * @date: 14:19 2018-10-19
     * @param: ip 连接的服务器的ip
     * @param: port 连接的服务器的端口号
     * @return: void
     */
    public void initClient(String ip, int port) throws IOException{
        // 获得一个Socket通道
        SocketChannel channel = SocketChannel.open();
        // 设置通道为非阻塞
        channel.configureBlocking(false);
        // 获得一个通道管理器
        this.selector = Selector.open();
        /** 客户端连接服务器，其实方法执行并没有实现连接，
            需要在listen()方法中调用channel.finishConnect();才能完成连接 **/
        channel.connect(new InetSocketAddress(ip, port));
        // 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件
        channel.register(selector, SelectionKey.OP_CONNECT);
    }

    /**
     * @Description: 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
     * @date: 14:22 2018-10-19
     * @param:
     * @return: void
     */
    public void listen() throws IOException{
        // 轮询访问selector
        while (true){
            selector.select();
            // 获得selector 中选中的项的迭代器
            Iterator<SelectionKey> ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()){
                SelectionKey key = ite.next();
                // 删除已选择的key，以防重复处理
                ite.remove();
                if (key.isConnectable()){ // 连接事件发生
                    SocketChannel channel = (SocketChannel) key.channel();
                    if (channel.isConnectionPending()){ // 如果正在连接，则完成连接
                        channel.finishConnect();
                    }
                    // 设置成非阻塞
                    channel.configureBlocking(false);
                    // 给服务端发信息
                    channel.write(ByteBuffer.wrap(new String("message to Server!").getBytes()));
                    // 在和服务端连接成功之后，为了可以接收服务端的信息，需要给通道设置读的权限
                    channel.register(this.selector, SelectionKey.OP_READ);
                } else if (key.isReadable()){ // 获得了可读的事件
                    read(key);
                }
            }
        }
    }

    /**
     * @Description: 处理服务端发来的信息 的事件
     * @date: 14:32 2018-10-19
     * @param: key 发来信息事件
     * @return: void
     */
    private void read(SelectionKey key) throws IOException {
        // 客户端可读取的消息：得到事件发生的Socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        // 创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(30);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("客户端收到消息：" + msg);
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
        channel.write(outBuffer);// 将消息回送给服务端
    }

    public static void main(String[] args) throws IOException{
        NIOClient client = new NIOClient();
        client.initClient("localhost", 8000);
        client.listen();
    }
}
