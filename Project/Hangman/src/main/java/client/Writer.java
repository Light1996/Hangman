package client;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Writer implements Runnable {

    private final String host;
    private ObjectInputStream in;
    List<String> chars = new ArrayList<>();
    private final int port;
    private PrintWriter out;
    private static Socket cSocket = null;
    public boolean flag = true;
    private final ClientGUI gui;
    private final LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();

    public Writer(ClientGUI gui, String host, int port) {
        this.host = host;
        this.port = port;
        this.gui = gui;
    }

    @Override
    public void run() {
        connect();
        callServer();
    }

    public void close() throws IOException {
        if (cSocket != null) {
            cSocket.close();
        }
    }

    public void connect() {
        try {
            cSocket = new Socket(host, port);
            new PrintStream(cSocket.getOutputStream());
            in = new ObjectInputStream(cSocket.getInputStream());
            out = new PrintWriter(cSocket.getOutputStream(), true);
            System.out.println("connected");
        } catch (UnknownHostException e) {
            gui.warn("Don't know about host: " + host + ".");
            System.exit(1);
        } catch (IOException e) {
            gui.warn("Couldn't get I/O for the connection to: "
                    + host + ".");
            System.exit(1);
        }
    }

    public void callServer() {
        Object response;
        Reader game;
        try {
            do {
                System.out.println("server called...");
                out.println(strings.take());
                response = in.readObject();
                if (response instanceof Reader) {
                    game = (Reader) response;
                    System.out.println("Response from server: " + game.getMessage() + " " + game.getWord() + " " + game.getCounter());
                    printGui(game);

                }
            } while (flag);
        } catch (UnknownHostException unHst) {
            System.out.println("/n Host didn 't found /n");
            System.exit(1);
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            System.out.println("Exiting the game...");
            System.exit(1);
        }
    }

    public void answer(String text) {
        strings.add(text);
        if (text.length() == 1 && !chars.contains(text)) {
            chars.add(text);
            gui.appendLetter(text);
        }

    }

    private void printGui(Reader data) {
        if ((data.getMessage().contains("Client") && data.getMessage().contains("Server"))) {
            gui.printScores(data.getMessage());
        } else {
            gui.showResult(data);
        }
    }
}
