package htl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread
{
    private Socket socket;

    public ServerThread(Socket s)
    {
        this.socket = s;
    }


    public void run()
    {
        try
        {
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));









        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }




}
