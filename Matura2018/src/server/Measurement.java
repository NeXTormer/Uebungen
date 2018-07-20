package server;

public class Measurement {
	
	private String m_Date;
	private String m_Room;
	private double m_Value;
	private String m_Unit;
	
	public Measurement(String room, double value, String unit, String date)
	{
		m_Room = room;
		m_Value = value;
		m_Unit = unit;
		m_Date = date;
		
	}
	
	public String getDate()
	{
		return m_Date;
	}
	
	public String getUnit()
	{
		return m_Unit;
	}

	public String getRoom()
	{
		return m_Room;
	}
	
	public double getValue()
	{
		return m_Value;
	}
	
	public String toString()
	{
		return "not yet implemented";
	}
}
