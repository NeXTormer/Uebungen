package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TicketHandlerThread extends Thread
{

    private Socket clientsocket;

    public TicketHandlerThread(Socket cs)
    {
        clientsocket = cs;
    }


    @Override
    public void run()
    {
        TicketDB db = TicketDB.getInstance();

        try
        {
            String input = "";
            PrintWriter out = new PrintWriter(clientsocket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
            do
            {
                input = in.readLine();
                System.out.println(input);
                if(input.equalsIgnoreCase("GET CONCERTS"))
                {
                    out.println(db.getConcerts());
                    out.flush();
                }
                else
                {
                    String[] in2 = input.split(" ");

                    if(in2[0].equalsIgnoreCase("GET") && in2[1].equalsIgnoreCase("TICKETS") && in2.length >= 4)
                    {
                        for(int i = 0; i < in2.length; i++) { }

                        String number = in2[in2.length-1];
                        String artist = "";
                        for(int i = 2; i < in2.length-1; i++)
                        {
                            artist += in2[i] + (i < in2.length-2 ? " " : "");
                        }
                        System.out.println(artist);

                        boolean success = db.decreaseTickets(artist, Integer.parseInt(in2[in2.length-1]));
                        if(success)
                        {
                            System.err.println("SUCCESS");
                            int tt = db.getAvailableTickets(artist);
                            out.println(artist.substring(0, 5) + tt + ":" + (tt+1 + Integer.valueOf(in2[in2.length-1])));
                            out.flush();
                            //1, 2, 3, 4, 5, 6
                        }
                    }
                }
            }
            while (!input.equals("exit"));

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }





    }



}
