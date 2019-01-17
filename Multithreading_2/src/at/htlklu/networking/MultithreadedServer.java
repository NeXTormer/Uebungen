package at.htlklu.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedServer
{



    public static void main(String[] args)
    {
        try
        {
            ServerSocket ss = new ServerSocket(5555);
            System.out.println("Server listening on port 5555...");

            while(true)
            {
                System.out.println("Waiting for connection...");

                Socket cs = ss.accept();

                Thread thread = new ServerThread(cs);
                thread.start();

            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
