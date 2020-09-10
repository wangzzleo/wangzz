package com.wangzz.tmp;



import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class GreetingServer extends Thread
{
    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
                BufferedInputStream in = new BufferedInputStream(server.getInputStream());
                byte[] bytes = "1".getBytes();
                int read = in.read(bytes);
                String s = new String(bytes);
                System.out.println(s);
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");
                server.close();
            }catch(SocketTimeoutException s)
            {
                System.out.println("Socket timed out!");
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String [] args)
    {
        try
        {
            Thread t = new GreetingServer(8886);
            t.start();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
