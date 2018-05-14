package net.ddns.faoiltiarna.stock;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Stockmarket {

    private ServerSocket m_ServerSocket;
    private Socket m_Socket;
    
    private OutputStream m_OutputStream;
    private InputStream m_InputStream;
    
    private PrintWriter m_PrintWriter;
    private BufferedReader m_BufferedReader;

    public static void main(String[] args) {
        new Stockmarket();
    }

    public Stockmarket()
    {
        connect();
    }

    private void connect()
    {
        try
        {
            m_ServerSocket = new ServerSocket(StockConstants.PORT);
            m_Socket = m_ServerSocket.accept();
            
            m_OutputStream = m_Socket.getOutputStream();
            m_InputStream = m_Socket.getInputStream();
        

            m_PrintWriter = new PrintWriter(m_OutputStream);
            m_BufferedReader = new BufferedReader(new InputStreamReader(m_InputStream));
            
            
            while(true)
            {
            	String input = m_BufferedReader.readLine();
            	System.out.println(input);
            	m_PrintWriter.println(input);
            	m_PrintWriter.flush();
            	
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
