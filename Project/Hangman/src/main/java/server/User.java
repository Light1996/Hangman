package server;

import java.io.*;
import java.net.*;

public class User extends Thread {

    private final Socket socket;
    private final Server server;
    private PrintWriter writer;
    public int room;
    public int points; 

    public User(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        this.room = 0;
        this.points = 0;
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
                this.room = Integer.parseInt(reader.readLine());
                server.addUserName(userName);
                String serverMessage = "New user connected: " + userName;
                server.broadcast(serverMessage, room, this);
                char[] blanks = new char[server.word.length()];
                for(int i=0;i<server.word.length();i++){
                    blanks[i] = '_';
                }
                server.broadcast("Guess the following word\n");
                String wordBlank = "";
                for(int i=0;i<blanks.length;i++){
                    wordBlank+=blanks[i]+" ";
                }
                server.broadcast(wordBlank);
                String clientMessage;
                do {
                    clientMessage = reader.readLine();
                    if(server.checkWord(clientMessage.toLowerCase())){
                        for(int i=0;i<server.word.length();i++){
                            if(server.word.toLowerCase().charAt(i)
                                    == clientMessage.toLowerCase().charAt(0)){
                                this.points+=2;
                                blanks[i] = server.word.charAt(i);
                            }
                        }
                        wordBlank="";
                        for(int i=0;i<blanks.length;i++){
                            wordBlank+=blanks[i]+" ";
                        }
                        server.broadcast(wordBlank);
                        if(server.checkWin(points)){
                            serverMessage = userName + " wins!!!";
                            server.broadcast(serverMessage);
                        }
                    }
                    serverMessage = "[" + userName + "]: " + clientMessage;
                    server.broadcast(serverMessage, room, this);
                } while (!clientMessage.equals("bye"));
                server.removeUser(userName, this);
                serverMessage = userName + " has quitted.";
                server.broadcast(serverMessage, room, this);
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
