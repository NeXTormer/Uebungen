import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static final int PORT = 9999;

    private Socket m_Socket;

    public Client()
    {
        try {
            m_Socket = new Socket("localhost", PORT);

            InputStream in = m_Socket.getInputStream();
            OutputStream out = m_Socket.getOutputStream();

            PrintWriter printWriter = new PrintWriter(out);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));


            Scanner sc = new Scanner(System.in);
            while(true)
            {
                printWriter.println(sc.next());
                printWriter.flush();
                System.out.println(reader.readLine());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
