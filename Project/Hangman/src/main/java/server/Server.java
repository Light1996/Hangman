package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private final int port;
    private final Set<String> userNames;
    private final Set<User> userThreads;
    public String word;

    public Server(int port) {
        this.userThreads = new HashSet<>();
        this.userNames = new HashSet<>();
        this.port = port;
        this.word = "";
    }

    public void execute() {
        String words[] = {"AMAZON","GOOGLE","ORACLE","ADOBE","FACEBOOK",
            "MICROSOFT","APPLE","CISCO","INTEL","SAMSUNG","RAKUTEN","NVIDIA",
            "DELL","ASUS","ACER","ACCENTURE","INFOSYS","WIPRO","PHILIPS","America"};
        try ( ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat Server is listening on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected");
                User newUser = new User(socket, this);
                userThreads.add(newUser);
                Random rand = new Random();
                int ind = rand.nextInt(20);
                this.word = words[ind];
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
    
    boolean checkWord(String guess){
        return this.word.toLowerCase().contains(guess);
    }
    
    boolean checkWin(int points){
        return (points/2)==this.word.length();
    }

    void broadcast(String message, int room, User excludeUser) {
        for (User aUser : userThreads) {
            if (aUser != excludeUser && aUser.room == room) {
                aUser.sendMessage(message);
            }
        }
    }
    
    void broadcast(String message) {
        for (User aUser : userThreads) {
            aUser.sendMessage(message);
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
