package gameserver;

import server.Server;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Iris on 05-Oct-16.
 */
public class Main {

    public static void main(String[] args) {
        Server server = new Server(8192);
        server.start();
        InetAddress address = null;
        int port = 8192;

        try {
            address = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        server.send(new byte[] {1, 1, 1, 1, 1, 2 }, address, port);

    }

}
