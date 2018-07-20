import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 9999;

    private ServerSocket m_ServerSocket;
    private Socket m_Socket;

    public Server()
    {
        try {
            m_ServerSocket = new ServerSocket(PORT);
            m_Socket = m_ServerSocket.accept();

            InputStream in = m_Socket.getInputStream();
            OutputStream out = m_Socket.getOutputStream();

            PrintWriter printWriter = new PrintWriter(out);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            while(true)
            {
                String read = reader.readLine();
                System.out.println(read);

                printWriter.println(read);
                printWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    public static void main(String[] args) {
        new Server();
    }
}
