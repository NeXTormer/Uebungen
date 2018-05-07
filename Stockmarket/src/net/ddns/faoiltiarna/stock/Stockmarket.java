package net.ddns.faoiltiarna.stock;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Stockmarket {

    private ServerSocket m_ServerSocket;
    private Socket m_Socket;

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
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
