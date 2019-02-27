import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server
{
    public Server()
    {
        try
        {
            ServerSocket ss = new ServerSocket(5555);
            System.out.println("Server listening on port 5555...");

            while(true)
            {
                System.out.println("Waiting for connection...");

                Socket cs = ss.accept();

                Thread thread = new SkiServerHandlerThread(cs);
                thread.start();

            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }



    public static void main(String[] args)
    {
        new Server();
    }


}
