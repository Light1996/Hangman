package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Writer extends Thread {

    private PrintWriter writer;
    private Socket socket;
    private Client client;

    public Writer(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;

        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
        }
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter your name: ");
        String userName = in.next();
        client.userName = userName;
        writer.println(userName);
        String text;
        in.nextLine();
        do {
            System.out.print("[" + userName + "]: ");
            text = in.nextLine();
            writer.println(text);

        } while (!text.equals("bye"));

        try {
            socket.close();
        } catch (IOException ex) {

            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }
}
