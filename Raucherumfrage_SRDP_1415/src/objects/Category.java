package objects;

public class Category
{

    private String m_ShortName;
    private String m_Name;
    private int m_ID;


    public Category(int id, String name, String shortname)
    {
        m_ShortName = shortname;
        m_ID = id;
        m_Name = name;
        System.out.println("ID: " + id + ", Name; " + name);
    }

    public String getName()
    {
        return m_Name;
    }

    public String getShortName()
    {
        return m_ShortName;
    }

    public int getID()
    {
        return m_ID;
    }
}
