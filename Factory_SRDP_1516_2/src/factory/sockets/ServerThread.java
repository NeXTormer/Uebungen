package factory.sockets;

import factory.db.JobDAO;

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

            while(true)
            {
                String i = reader.readLine();
                System.out.println(i);
                String[] input = i.split(" ");

                if(input.length == 0) continue;

                if(input[0].equalsIgnoreCase("EXIT"))
                {
                    break;
                }
                else if(input[0].equalsIgnoreCase("DELETE"))
                {
                    if(input.length == 2)
                    {
                        int id = Integer.parseInt(input[1]);
                        JobDAO.delete(id);
                        writer.println("DELETED " + id);
                        writer.flush();
                    }
                }
                else if(input[0].equalsIgnoreCase("schub"))
                {
                    writer.println("SCHUB!");
                    writer.flush();
                }
                else
                {
                    writer.println("Hawara was willst du?");
                    writer.flush();
                }



            }


        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
