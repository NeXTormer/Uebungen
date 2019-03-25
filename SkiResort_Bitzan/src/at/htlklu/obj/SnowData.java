package at.htlklu.obj;

import java.time.LocalDate;
import java.util.Date;

public class SnowData implements Comparable<SnowData>
{
	private int id;
	private int skiResortId;
	private int depth;
	private LocalDate date;
	
	public SnowData(int id, int skiResortId, int depth, LocalDate date)
	{
		super();
		this.id = id;
		this.skiResortId = skiResortId;
		this.depth = depth;
		this.date = date;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public int getSkiResortId()
	{
		return skiResortId;
	}

	public void setSkiResortId(int skiResortId)
	{
		this.skiResortId = skiResortId;
	}

	public int getDepth()
	{
		return depth;
	}

	public void setDepth(int depth)
	{
		this.depth = depth;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public void setDate(LocalDate date)
	{
		this.date = date;
	}

	@Override
	public int compareTo(SnowData sd) {
		// TODO Auto-generated method stub
		return sd.depth-this.depth;
	}
	
	
	
	

}
