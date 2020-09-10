package com.wangzz.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TcpBlockTest {

    public static void main(String [] args)
    {
        try
        {
            System.out.println("连接到主机：" + "localhost" + " ，端口号：" + 8888);
            Socket client = new Socket("localhost", 8888);
            client.setSoTimeout(2000);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());
            client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
