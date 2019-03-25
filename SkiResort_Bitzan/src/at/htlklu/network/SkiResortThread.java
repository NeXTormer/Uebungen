package at.htlklu.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import at.htlklu.db.DBConnection;
import at.htlklu.db.SkiResortDAO;
import at.htlklu.db.SnowDataDAO;
import at.htlklu.obj.SkiResort;
import at.htlklu.obj.SnowData;

public class SkiResortThread extends Thread{

	
	private Socket clientsocket;
	private List<SkiResort> skiresorts = new ArrayList<>();
	
	public SkiResortThread(Socket clientsocket) 
	{
		super();
		this.clientsocket = clientsocket;
	}
	
	public void init() throws ClassNotFoundException, SQLException
	{
		
	}

	@Override
	public void run() 
	{
		
		try 
		{
			PrintWriter out = new PrintWriter(clientsocket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
			out.flush();
			
			boolean stop = false;
			while (!stop)
			{
				String line = in.readLine().toUpperCase();
				
				if(line.startsWith("INIT"))
				{
					skiresorts = SkiResortDAO.getSkiResorts();
					String data = "";
					for( int i = 0; i<skiresorts.size(); i++)
					{
						data+=skiresorts.get(i).getName();
						if(i!=skiresorts.size()-1)
						{
							data+="*";
						}
					}
					out.println(data);
				}
				else if(line.startsWith("ADD"))
				{
					String[] temp = line.split("\\*");
					for(int i = 0; i<skiresorts.size(); i++)
					{
						if(temp[1].equalsIgnoreCase(skiresorts.get(i).getName()))
						{
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd");
							formatter = formatter.withLocale( Locale.GERMANY);  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
							LocalDate date = LocalDate.parse(temp[3], formatter);
							SnowData sd = new SnowData(0, skiresorts.get(i).getId(), Integer.parseInt(temp[2]), date);
							//out.println(date);
							SnowDataDAO.addSnowData(sd);
							//out.println("OK");
						}
						else
						{
							//out.println("NOK");
						}
					}
					//out.println("Added");
					
	
				}
				else if(line.startsWith("GET"))
				{
					List<SnowData> snowdata = new ArrayList<>();
					String data = "";
					for(int l = 1; l<=skiresorts.size(); l++)
					{
						snowdata.add(SnowDataDAO.getSnowData(l));	
					}
					Collections.sort(snowdata);
					for(int i = 0; i<snowdata.size(); i++)
					{
						String monthS = "";
						if(snowdata.get(i).getDate().getMonthValue()<10)
						{
							monthS = "0"+snowdata.get(i).getDate().getMonthValue();
						}
						else
						{
							monthS = ""+snowdata.get(i).getDate().getMonthValue();
						}
						String dayS = "";
						if(snowdata.get(i).getDate().getDayOfMonth()<10)
						{
							dayS = "0"+snowdata.get(i).getDate().getDayOfMonth();
						}
						else
						{
							dayS = ""+snowdata.get(i).getDate().getDayOfMonth();
						}
						String dateS = snowdata.get(i).getDate().getYear()+":"+monthS+":"+dayS;
						
						data=skiresorts.get(snowdata.get(i).getSkiResortId()-1).getName()+"*"+snowdata.get(i).getDepth()+"*"+dateS;
						out.println(data);
					}
					out.println("...");
					
				}
				else if (line.equals("EXIT"))
				{
					stop = true;
				} 
				else
				{
					out.println("Unknown");
				}
				out.flush();
			}
			
			clientsocket.close();
			
		} 
		catch (IOException | ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
