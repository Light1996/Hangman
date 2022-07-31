package server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class User {

    File file;
    String word;
    String dashed;
    List<Character> found;

    public User() throws FileNotFoundException {
        this.found = new ArrayList<>();
        this.file = getFile();
        this.word = selectWord();
        this.dashed = word.replaceAll(".", " _");
        System.out.println("Word selected: " + word);

    }

    public String getDashed() {
        return generateDashes();
    }

    public void addToFound(Character c) {
        this.found.add(c);
    }

    public boolean ifFoundListIncludes(char[] s) {
        return found.contains(s[0]);
    }

    private String selectWord() throws FileNotFoundException {
        String str = "";
        do {
            str = chooseWord();
        } while ((!str.matches((".*\\d+.*"))) && (str.length() < 3));
        return str;
    }

    public String getWord() {
        return this.word;
    }

    private File getFile() {
        URL url = getClass().getResource("words.txt");
        file = new File("words.txt");
        return file;
    }

    private String chooseWord() throws FileNotFoundException {
        String result = null;
        Random rand = new Random();
        int n = 0;
        for (Scanner sc = new Scanner(file); sc.hasNext();) {
            ++n;
            String line = sc.nextLine();
            if (rand.nextInt(n) == 0) {
                result = line.toLowerCase();
            }
        }
        return result;
    }

    public String generateDashes() {
        if (!found.isEmpty()) {
            StringBuilder result = new StringBuilder(found.size());
            found.stream().forEach((c) -> {
                result.append(c);
            });
            String output = result.toString();
            String except = "[^" + output + "]";
            this.dashed = word.replaceAll(except, " _");
        }
        return this.dashed;

    }

    public boolean compareTotal(String guess) throws IOException {
        return guess.equalsIgnoreCase(word);
    }

    public boolean checkCompleteness() {
        return !this.dashed.contains("_");
    }
}
