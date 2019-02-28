import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SkiData
{
    private SkiResort resort;
    private int snowDepth;
    private LocalDate date;

    public SkiData(SkiResort resort, int snowDepth_, LocalDate date_)
    {
        this.resort = resort;
        this.snowDepth = snowDepth_;
        this.date = date_;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public SkiResort getName()
    {
        return resort;
    }

    public int getSnowDepth()
    {
        return snowDepth;
    }

    @Override
    public String toString()
    {
        return resort + "*" + snowDepth + "*" + date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
