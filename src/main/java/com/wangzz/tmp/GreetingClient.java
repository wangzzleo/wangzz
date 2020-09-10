package com.wangzz.tmp;

import java.net.*;
import java.io.*;

public class GreetingClient
{
    public static void main(String [] args)
    {
        try
        {
            System.out.println("连接到主机：" + "serverName" + " ，端口号：" + 8886);
            Socket client = new Socket("localhost", 8886);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            BufferedOutputStream out = new BufferedOutputStream(outToServer);
            byte[] tmp = "a".getBytes();
            out.write(tmp);
            out.flush();
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
