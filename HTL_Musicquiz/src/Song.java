import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Song {

	private String m_Title;
	private String m_Interpret;
	
	private int m_ID;
	
	private URL m_URL;
	
	private List<Vote> m_Votes;
	
	public Song(String title, String interpret, String url, int id) throws MalformedURLException
	{
		m_Title = title;
		m_Interpret = interpret;
		m_URL = new URL(url);
		m_ID = id;
	}
	
}
