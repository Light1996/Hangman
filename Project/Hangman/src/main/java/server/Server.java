package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private final int port;
    private final Set<String> userNames;
    private final Set<User> userThreads;

    public Server(int port) {
        this.userThreads = new HashSet<>();
        this.userNames = new HashSet<>();
        this.port = port;
    }

    public void execute() {
        try ( ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat Server is listening on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected");
                User newUser = new User(socket, this);
                userThreads.add(newUser);
                newUser.start();
            }
        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        int port = 8598;
        Server server = new Server(port);
        server.execute();
    }

    void broadcast(String message, User excludeUser) {
        for (User aUser : userThreads) {
            if (aUser != excludeUser) {
                aUser.sendMessage(message);
            }
        }
    }

    void addUserName(String userName) {
        userNames.add(userName);
    }

    void removeUser(String userName, User aUser) {
        boolean removed = userNames.remove(userName);
        if (removed) {
            userThreads.remove(aUser);
            System.out.println("The user " + userName + " quitted");
        }
    }

    Set<String> getUserNames() {
        return this.userNames;
    }

    boolean hasUsers() {
        return !this.userNames.isEmpty();
    }
}
