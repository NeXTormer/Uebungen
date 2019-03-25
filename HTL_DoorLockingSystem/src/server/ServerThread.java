package server;

import obj.Room;
import obj.RoomDAO;

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
        String input = "";

        do
        {
            try
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());

                input = reader.readLine();

                String[] in = input.split(" ");
                Room room = null;
                System.out.println(input);
                System.out.println(in[0]);
                if(in[0].equalsIgnoreCase("LOCK"))
                {
                    room = RoomDAO.getRoom(in[1]);
                    room.setLocked(true);
                }
                else if(in[0].equalsIgnoreCase("UNLOCK"))
                {
                    room = RoomDAO.getRoom(in[1]);
                    room.setLocked(false);
                }

                if(RoomDAO.update(room))
                {
                    writer.println("OK");
                }
                else
                {
                    writer.println("NOK");
                }
                writer.flush();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

        }
        while(!input.equalsIgnoreCase("EXIT"));
    }


}
