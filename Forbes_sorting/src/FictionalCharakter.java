import java.util.Arrays;
import java.util.Random;

public class FictionalCharakter implements Comparable<FictionalCharakter> {

	public static boolean compareFortune = true;
	
	public String name = "";
	public int fortune = 0;
	public String residence = "";
	public String[] sourceOfIncome;
	
	public int numberOfIncomes = 0;
	
	public FictionalCharakter(String n, int f, String res, String[] soe)
	{
		this.name = n;
		this.fortune = f;
		this.residence = res;
		this.sourceOfIncome = soe;
		
		for(String s : sourceOfIncome)
		{
			numberOfIncomes++;
		}
	}

	
	
	@Override
	public String toString()
	{
		return name + " - " + Float.toString(fortune / 10.0f) + " - " + residence + " " + Arrays.toString(sourceOfIncome);
	}



	@Override
	public int compareTo(FictionalCharakter arg0) {
		if(compareFortune)
		{
			return arg0.fortune - this.fortune;	
		}
		else
		{
			int diff = arg0.numberOfIncomes - this.numberOfIncomes;
			if(diff == 0)
			{
				double rnd = Math.random();
				if(rnd < 0.5d)
				{
					return -1;
				}
				else
				{
					return 1;
				}
			}
			else
			{
				return diff;
			}
		}
	}
}
