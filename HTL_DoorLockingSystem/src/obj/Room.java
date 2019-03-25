package obj;

public class Room
{
    private int id;
    private String name;
    private boolean locked;

    public Room(int id, String name, boolean locked)
    {
        this.id = id;
        this.name = name;
        this.locked = locked;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public boolean isLocked()
    {
        return locked;
    }
}
