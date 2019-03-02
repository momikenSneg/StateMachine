package mashine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Maсhine {
    private Map<Integer, State> states = new HashMap<>();
    private String recString;
    private State currentState;

    public Maсhine(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            states = null;
        }
        Scanner scanner = new Scanner(file);
        String[] finalStates = {};
        if (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            finalStates = s.split(" ");
        }
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] segue = s.split(" ");
            if (segue.length != 3) {
                states = null;
            }
            if (segue[1].length() != 1) {
                states = null;
            }
            int from = Integer.valueOf(segue[0]);
            int to = Integer.valueOf(segue[2]);
            char symbol = segue[1].charAt(0);
            if (states.get(from) == null) {
                states.put(from, new State());
            }
            states.get(from).addTransition(new Transition(from, to, symbol));
        }
        for (String s: finalStates) {
            int num = Integer.valueOf(s);
            if (states.get(num) == null) {
                states.put(num, new State());
            }
            states.get(num).setFinal(true);
        }
    }

    public void getStringFromFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            recString = null;
        }
        Scanner scanner = new Scanner(file);
        if (scanner.hasNextLine()) {
            recString = scanner.nextLine();
        } else {
            recString = null;
        }

    }

    public boolean recognizeString() {
        currentState = states.get(1);
        for (int i = 0; i < recString.length(); ++i) {
            State state = states.get(currentState.getNext(recString.charAt(i)));
            if (state == null) {
                return false;
            }
            currentState = state;
        }
        return currentState.isFinal();
    }
}
