package factory.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{

    public static void main(String[] args)
    {
        try
        {
            ServerSocket ss = new ServerSocket(88);
            while(true)
            {
                Socket socket = ss.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
