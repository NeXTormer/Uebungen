import company.database.Database;
import objects.Participant;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class main {

    public static void main(String[] args)
    {
        Database db = new Database("faoiltiarna.ddns.net", "htl_skirace_2", "holz", "PeterRendl69!");

        ArrayList<Participant> participants;

        participants = Participant.loadParticipants(db.getConnection());
        Collections.sort(participants);

        for(Participant p : participants)
        {
            System.out.println(p);
        }

    }
}
