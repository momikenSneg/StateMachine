package mashine;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Maсhine machine = new Maсhine(args[0]);
        machine.getStringFromFile(args[1]);
        machine.recognizeString();
    }

}
