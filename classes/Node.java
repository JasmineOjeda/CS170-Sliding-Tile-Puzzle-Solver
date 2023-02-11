package classes;

import java.util.*;

public class Node {
    public Node parent;
    public ArrayList<Node> children;
    public Problem state;
    public int utility;
    public String action;
    public String[] actions = {"Move right", "Move left", "Move down", "Move up"};
    
    public Node(int puzzle[][]) {
        state = new Problem(puzzle);
        children = new ArrayList<Node>();
        parent = null;
        utility = 0;
        action = "";
    }

    public Node(int puzzle[][], Node par, int cost, String act) {
        state = new Problem(puzzle);
        children = new ArrayList<Node>();
        parent = par;
        utility = cost;
        action = act;
    }

    public boolean expandNode(int cost, String act) {
        children.add(new Node(state.puzzle, this, utility + cost, act));
        boolean valid = false;
        if (act.equals("Move right")) {
            valid = children.get(children.size() - 1).state.moveBlankRight();
        }
        else if (act.equals("Move left")) {
            valid = children.get(children.size() - 1).state.moveBlankLeft();
        }
        else if (act.equals("Move up")) {
            valid = children.get(children.size() - 1).state.moveBlankUp();
        }
        else if (act.equals("Move down")) {
            valid = children.get(children.size() - 1).state.moveBlankDown();
        }

        return valid;
    }
}