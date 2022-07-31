package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket serverSocket;
    private static final int PORT = 5215;
    private static final boolean listening = true;

    public static void main(String[] args) throws IOException {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Welcome to the hangman game!");
        } 
        catch (IOException expIO) {
            System.out.println("\n Unable to set up port " + PORT);
            System.exit(1);
        }

        while (listening) {
            Socket client = serverSocket.accept();
            Controller hc = new Controller(client);
            hc.start();
        }
    }
}
