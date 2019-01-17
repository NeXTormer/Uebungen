package at.htlklu.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            Socket socket = new Socket("localhost", 5555);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line = in.readLine();
            System.out.println(line);

            while((line=in.readLine()) != null)
            {
                System.out.println(line);
                String input = sc.nextLine();
                out.println(input);
                out.flush();
            }


        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }


}
