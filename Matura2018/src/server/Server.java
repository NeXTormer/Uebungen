package server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 8888;

    private ServerSocket m_ServerSocket;
    private Socket m_Socket;
    
    private Database m_Database;

    public Server()
    {
        try {
            m_ServerSocket = new ServerSocket(PORT);

            m_Database = new Database("faoiltiarna.ddns.net", "htl_roommonitor", "user", "PeterRendl69!");
            
            m_Socket = m_ServerSocket.accept();




            InputStream in = m_Socket.getInputStream();
            OutputStream out = m_Socket.getOutputStream();

            PrintWriter printWriter = new PrintWriter(out);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            while(true)
            {
                String read = reader.readLine();

                printWriter.println(read);
                printWriter.flush();
                
                String[] split = read.split(" ");
                if(split[0].equalsIgnoreCase("ADD"))
                {
                	if(split.length == 5)
                	{
                		String room = split[1];
                		String value = split[2];
                		String unit = split[3];
                		String time = split[4];
                		time = "0:0:0 " + time;
                		
                		m_Database.Update("INSERT INTO measurements (room, time, value, unit) VALUES (?, ?, ?, ?);", room, time, value, unit);	
                	
                		m_Database.lastMeasurements();
                	
                	}
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Server();
    }
    
}