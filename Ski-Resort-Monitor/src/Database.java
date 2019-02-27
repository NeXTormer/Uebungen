import java.util.ArrayList;

public class Database
{

    private static Database instance;

    public static Database getInstance()
    {
        if(instance == null)
        {
            instance = new Database();
        }
        return instance;
    }

    private ArrayList<SkiData> data;

    public Database()
    {
        data = new ArrayList<>();
    }

    public ArrayList<SkiData> getData()
    {
        return data;
    }
}
