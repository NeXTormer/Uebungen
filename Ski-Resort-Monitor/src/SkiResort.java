import java.util.ArrayList;

public class SkiResort
{

    public static ArrayList<SkiResort> resorts;

    static
    {
        resorts = Database.getInstance().getResorts();
    }

    public static SkiResort getResort(String name)
    {
        for(SkiResort r : resorts)
        {
            if(name == r.getName())
            {
                return r;
            }
        }
        return null;
    }

    private String name;

    public SkiResort(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public String toString()
    {
        return name;
    }
}
