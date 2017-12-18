import java.sql.Date;

public class Vote {

	private int m_ID;
	
	private Date m_Time;
	
	private String m_Team;
	
	public Vote(Date date, String team, int id)
	{
		m_Time = date;
		m_Team = team;
		m_ID = id;
	}
}
