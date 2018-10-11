package objects;

public class Category
{

    private String m_Name;
    private int m_ID;


    public Category(int id, String name)
    {
        m_ID = id;
        m_Name = name;
        System.out.println("ID: " + id + ", Name; " + name);
    }

    public String getName()
    {
        return m_Name;
    }

    public int getID()
    {
        return m_ID;
    }
}
