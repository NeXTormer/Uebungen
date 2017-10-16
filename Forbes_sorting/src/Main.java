import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class Main {

	public static TreeSet<FictionalCharakter> charakters = new TreeSet<FictionalCharakter>();
	
	
	public static void main(String[] args)
	{
		
		sortByFortune();
		sortBySourceOfIncome();
	
	}
	
	public static void sortByFortune()
	{
		FictionalCharakter.compareFortune = true;
		
		charakters.clear();
		readInput();
	
		
		FileWriter fw;
		try {
			fw = new FileWriter("sorted_by_income.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(FictionalCharakter c : charakters)
			{
				bw.write(c.toString() + "\n");
			}
		
			bw.flush();
			bw.close();
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void sortBySourceOfIncome()
	{
		FictionalCharakter.compareFortune = false;
	
		charakters.clear();
		readInput();
	
		
		FileWriter fw;
		
		try {
			fw = new FileWriter("sorted_by_source_of_income.txt");
			BufferedWriter bw = new BufferedWriter(fw);
		
			
			for(FictionalCharakter c : charakters)
			{
				bw.write(c.toString() + "\n");
			}
		
			bw.flush();
			bw.close();
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readInput()
	{
		try {
			List<String> in = Files.readAllLines(Paths.get("input.txt"));
		
			for(String s : in)
			{
				String[] v = s.split(";");
				charakters.add(new FictionalCharakter(v[0], Integer.parseInt(v[1]), v[2], v[3].split(",")));
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
