package factory.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{

    public static void main(String[] args)
    {
        try
        {
            Socket socket = new Socket("localhost", 88);

            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner sc = new Scanner(System.in);

            while(true)
            {
                String in = sc.nextLine();
                System.err.println(in);
                writer.println(in);
                writer.flush();
                System.out.println(reader.readLine());
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
