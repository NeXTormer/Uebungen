package at.htlklu.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SkiResortServer
{
	public static final int PORT = 6969; 
	

	public static void main(String[] args)
	{
		SkiResortServer server = new SkiResortServer();
		server.start();
	}
	
	public SkiResortServer()
	{
		
	}
	
	public void start()
	{
		try 
		{
			ServerSocket serverSock = new ServerSocket(PORT);
			for( ; ; )
			{
				
				Socket clientSock = serverSock.accept();
				SkiResortThread t = new SkiResortThread(clientSock);
				t.start();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
