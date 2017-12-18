import java.net.MalformedURLException;
import java.sql.SQLException;

public class main {

	public static void main(String[] args)
	{
		QuizManager manager = new QuizManager();
		
		try {
			int t1 = manager.AddTeam("A - Team");
			int t2 = manager.AddTeam("B - Team");
			
			System.out.println("Created Teams: " + t1 + ", " + t2);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try 
		{
			manager.AddSong("Presslufthammer Bernhard", "Torfrock", "https://www.youtube.com/watch?v=j4TM3Ytqgj0");
			manager.AddSong("Sacred Woods", "Varien", "https://www.youtube.com/watch?v=eesT_WgDqbg");
			manager.AddSong("Valkyrie", "Varien", "https://www.youtube.com/watch?v=RDhqko-Ivi0");

		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}

		manager.Vote("TORFINDENIG", 2, 2);
		
	}
}
