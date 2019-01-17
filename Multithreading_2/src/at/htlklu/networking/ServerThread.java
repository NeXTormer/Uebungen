package at.htlklu.networking;

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
        super();
        socket = s;
    }

    @Override
    public void run()
    {
        PrintWriter out = null;

        String inwerner = "";
        do
        {
            try
            {
                out = new PrintWriter(socket.getOutputStream());

                out.println("hello client, tell me something...");
                out.flush();

                BufferedReader in = null;
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String input = null;
                input = in.readLine();

                out.println("you wrote: " + input);
                out.flush();

                inwerner = input;
                System.out.println(inwerner);
            } catch (IOException e)
            {
                e.printStackTrace();
            }

        }
        while (!inwerner.equals("exit"));
    }


}