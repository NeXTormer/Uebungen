package htl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Server
{

    public static void main(String[] args)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = LocalDate.parse("WERNER", dtf);


//        try
//        {
//            ServerSocket ss = new ServerSocket(8888);
//
//            while(true)
//            {
//                Socket s = ss .accept();
//                ServerThread st = new ServerThread(s);
//                st.start();
//            }
//
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
    }
}
