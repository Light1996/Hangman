package server;

import java.io.*;
import java.net.*;

public class User extends Thread {

    private final Socket socket;
    private final Server server;
    private PrintWriter writer;

    public User(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            try (socket) {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = socket.getOutputStream();
                writer = new PrintWriter(output, true);
                printUsers();
                String userName = reader.readLine();
                server.addUserName(userName);
                String serverMessage = "New user connected: " + userName;
                server.broadcast(serverMessage, this);
                String clientMessage;
                do {
                    clientMessage = reader.readLine();
                    serverMessage = "[" + userName + "]: " + clientMessage;
                    server.broadcast(serverMessage, this);
                } while (!clientMessage.equals("bye"));
                server.removeUser(userName, this);
                serverMessage = userName + " has quitted.";
                server.broadcast(serverMessage, this);
            }
        } catch (IOException ex) {
            System.out.println("Error in UserThread: " + ex.getMessage());
        }
    }

    void printUsers() {
        if (server.hasUsers()) {
            writer.println("Connected users: " + server.getUserNames());
        } else {
            writer.println("No other users connected");
        }
    }

    void sendMessage(String message) {
        writer.println(message);
    }
}
