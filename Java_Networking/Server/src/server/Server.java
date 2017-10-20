package server;

import com.thecherno.raincloud.serialization.RCDatabase;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by Iris on 05-Oct-16.
 */
public class Server {

    //TODO: EP5

    // edit 1

    private static final int MAX_PACKET_SIZE = 1024;
    private static final byte[] RCDB_HEADER_STRING = new byte[] { 'R', 'C', 'D', 'B' };

    private int port;

    private Thread listenThread;
    private boolean listening = false;
    private DatagramSocket socket;

    private byte[] receivedDataBuffer = new byte[MAX_PACKET_SIZE * 10];

    public Server(int port) {
        this.port = port;

    }

    public void start() {
        listening = true;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
            return;
        }



        listenThread = new Thread(() -> listen(), "Server listening thread");
        listenThread.start();

        System.out.println("Server started on port " + port);
    }

    private void listen() {

        while(listening) {
            DatagramPacket packet = new DatagramPacket(receivedDataBuffer, MAX_PACKET_SIZE);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            process(packet);
        }
    }

    private void process(DatagramPacket packet) {
        byte[] data = packet.getData();
        if(new String(data, 0, 4).equals("RCDB")) {
            RCDatabase database = RCDatabase.Deserialize(data);
            process(database);
        } else {
            switch(data[0]) {
                case 1:
                    //connection package
                    break;
                case 2:
                    //ping packet
                    break;
                case 3:
                    //
                    break;
            }

        }
    }

    private void process(RCDatabase database) {

    }

    public void send(byte[] data, InetAddress address, int port) {
        //assert(socket.isConnected());
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }










    public int getPort() { return port ; }

}
