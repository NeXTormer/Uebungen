import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SkiData
{
    private String name;
    private int snowDepth;
    private Date date;

    public SkiData(String _name, int snowDepth_, Date date_)
    {
        this.name = _name;
        this.snowDepth = snowDepth_;
        this.date = date_;
    }

    public Date getDate()
    {
        return date;
    }

    public String getName()
    {
        return name;
    }

    public int getSnowDepth()
    {
        return snowDepth;
    }

    @Override
    public String toString()
    {
        return name + "*" + snowDepth + "*" + date.toString();
    }
}
