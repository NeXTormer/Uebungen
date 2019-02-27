import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Date;

public class SkiServerHandlerThread extends Thread
{
    Socket socket;

    public SkiServerHandlerThread(Socket socket)
    {
        this.socket = socket;
    }

    public void run()
    {
        try
        {
            String input = "";
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true)
            {
                input = in.readLine();
                System.out.println("Input Command: " + input);
                String[] split = input.split("/*/");

                if(split[0].equalsIgnoreCase("ADD") && split.length == 4)
                {
                    SkiData sd = new SkiData(split[1], Integer.parseInt(split[2]), Date.valueOf(split[3]));
                    if(Database.getInstance().getData().add(sd))
                    {
                        out.println("OK");
                    }
                    else
                    {
                        out.println("NOK");
                    }
                    out.flush();
                }
                else if(split[0].equalsIgnoreCase("GET") && split.length == 1)
                {
                    for(SkiData sd : Database.getInstance().getData())
                    {
                        out.println(sd);
                    }
                    out.flush();
                }
                else
                {
                    break;
                }
            }

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
