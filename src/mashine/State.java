package mashine;

import java.util.ArrayList;
import java.util.List;

public class State {

    private boolean isFinal = false;
    private List<Transition> transitions = new ArrayList<>();

    public void addTransition(Transition transition) {
        transitions.add(transition);
    }

    public int getNext(char symbol) {
        for (Transition segue: transitions) {
            if (segue.getSymbol() == symbol) {
                return segue.getTo();
            }
        }
        return -1;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public boolean isFinal() {
        return isFinal;
    }
}
