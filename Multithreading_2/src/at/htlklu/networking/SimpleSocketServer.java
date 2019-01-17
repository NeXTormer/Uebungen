package at.htlklu.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketServer
{

    public static void main(String[] args)
    {
        try
        {

            while(true)
            {
                ServerSocket ss = new ServerSocket(5555);
                System.out.println("Server listening on port 5555...");
                System.out.println("Waiting for connection...");

                Socket cs = ss.accept();

                PrintWriter out = new PrintWriter(cs.getOutputStream());
                out.println("hello client, tell me something...");
                out.flush();

                BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));

                String input = in.readLine();

                out.println("you wrote: " + input);
                out.flush();

                cs.close();

            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
