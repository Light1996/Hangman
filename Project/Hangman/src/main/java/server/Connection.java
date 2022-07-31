package server;

import java.io.*;
import java.net.*;
import client.Reader;

public class Connection {
    private final BufferedReader input;
    private final ObjectOutputStream output;
    private final Socket socket;

    public Connection(Socket client) throws IOException {
        this.socket = client;
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        output = new ObjectOutputStream(client.getOutputStream());
    }

    public void sendMessage(Reader data) throws IOException {
        output.reset();
        output.writeObject(data);
        output.flush();
    }

    public void close() {
        try {
            if (socket != null) {
                try (socket) {
                    System.out.println("closing the server....");
                }
            }
        } catch (IOException exp) {
        }
    }

    public String readMessage() throws IOException {
        return input.readLine();
    }
}
