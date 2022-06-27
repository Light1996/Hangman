package client;

import java.net.*;
import java.io.*;

public class Client {
    private final int port;
    public String userName;

    public Client(int port) {
        this.port = port;
    }

    public void execute() {
        try {
            Socket socket = new Socket("localhost", port);
            System.out.println("Connected to the server");
            new Reader(socket, this).start();
            new Writer(socket, this).start();

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }

    }

    public static void main(String[] args) {
        int port = 8598;
        Client client = new Client(port);
        client.execute();
    }
}
