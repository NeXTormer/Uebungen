package server;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TicketDB
{

    public static TicketDB instance;

    private HashMap<String, Integer> tickets;


    public static TicketDB getInstance()
    {
        if(instance == null)
        {
            instance = new TicketDB();
        }
        return instance;
    }

    private TicketDB()
    {
        tickets = new HashMap<>();
        initializeDB();

        System.out.println(getConcerts());
    }

    private void initializeDB()
    {
        tickets.put("The Rolling Stones", 4);
        tickets.put("AC/DC", 2);
        tickets.put("StMiT", 0);
        tickets.put("Helene Fischer", 72341);
        tickets.put("Ed Sheeran", 0);
        tickets.put("Logic", 2);
    }

    public synchronized int getAvailableTickets(String artist)
    {
        return tickets.get(artist);
    }

    /**
     * removes nr of tickets from artist
     * @param artist
     * @param nr
     * @return true if successful, false if the tickets have sold outs
     */
    public synchronized boolean decreaseTickets(String artist, int nr)
    {
        int at = getAvailableTickets(artist);
        if(nr <= at)
        {
            tickets.put("artist", at-nr);
            return true;
        }
        return false;
    }

    public synchronized String getConcerts()
    {
        String output = "";
        Iterator it = tickets.entrySet().iterator();
        int size = tickets.size();
        int count = 0;
        while(it.hasNext())
        {
            count++;
            Map.Entry pair = (Map.Entry) it.next();
            output += pair.getKey() + "#" + pair.getValue() + (count < size ? ":" : "");
        }
        return output;
    }

}
