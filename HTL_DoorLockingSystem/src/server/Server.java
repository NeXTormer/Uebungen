package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{

    public static void main(String[] args)
    {
        try
        {
            ServerSocket ss = new ServerSocket(8888);

            while(true)
            {
                Socket s = ss.accept();
                ServerThread st = new ServerThread(s);
                st.start();
            }


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
