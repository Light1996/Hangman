package server;

import java.io.*;
import java.net.*;
import client.Reader;

public class Controller extends Thread {

    private Reader reader;
    private final User user;
    private final Connection connect;
    private String user_input;
    private int cScore = 0;
    private int sScore = 0;

    public Controller(Socket client) throws IOException {
        connect = new Connection(client);
        user = new User();
    }

    @Override
    public void run() {
        try {
            initGame();
        } catch (IOException ex) {
        }
    }

    private void initGame() throws IOException {
        user_input = connect.readMessage();
        reader = new Reader(user_input, user.dashed);
        System.out.println("Message received: " + user_input);
        connect.sendMessage(reader);
        while ((!user_input.equals("QUIT"))) {
            user_input = connect.readMessage();
            if (user_input.equals("scores")) {
                reader.setscoresMessage(cScore, sScore);
            }
            else if (reader.getCounter() == 0) {
                reader.setLooseMessage();
                writeScore("server");
            }
            else if ((user_input.length() > 1) && (user.compareTotal(user_input))) {
                reader.setCongratsMessage();
                reader.setWord(user.word);
                writeScore("client");
            } 
            else if (user.ifFoundListIncludes(user_input.toCharArray())) {
                reader.setWord(user.generateDashes());
                reader.setInvalidTryMessage(user_input);
            } 
            else if ((user.getWord().contains(user_input)) && (user_input.length() == 1)) {
                user.addToFound(user_input.toCharArray()[0]);
                reader.setWord(user.generateDashes());
                if (user.checkCompleteness()) {
                    reader.setCongratsMessage();
                    reader.setWord(user.word);
                    writeScore("client");
                } else {
                    reader.setFoundMessage();
                    writeScore("client");
                }
            } 
            else {
                user.addToFound(user_input.toCharArray()[0]);
                reader.disincrementCounter();
                reader.setRetryMessage(user_input);
                reader.setWord(user.generateDashes());
            }
            connect.sendMessage(reader);
        }
        connect.close();
    }

    private void writeScore(String s) {
        switch (s) {
            case "client" -> {
                cScore++;
                System.out.println("client score update" + cScore);
            }
            case "server" -> {
                sScore++;
                System.out.println("server score update" + sScore);
            }
        }
    }
}
