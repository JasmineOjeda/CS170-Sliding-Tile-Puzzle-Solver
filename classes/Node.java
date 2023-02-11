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

    public boolean expandNode(int cost_type, String act) {
        int cost = 0;

        children.add(new Node(state.puzzle, this, utility, act));
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

        cost = calculateCostFromType(cost_type, state.goal, state.puzzle);
        children.get(children.size() - 1).utility += cost;

        return valid;
    }

    public static int calculateCostFromType(int cost_type, int[][] goal, int[][] puzzle) {
        int cost = 0;

        if (cost_type == 0) {
            cost = 1;
        }
        else if (cost_type == 1) {
            cost = misplacedTileHeuristic(goal,puzzle);
        }
        else if (cost_type == 2) {
            cost = euclideanDistanceHeuristic(goal, puzzle);
        }

        return cost;
    }

    // A* HEURISTIC FUNCTIONS
    public static int misplacedTileHeuristic(int[][] goal, int[][] puzzle) {
        int cost = 0;

        for (int i = 0; i < goal.length; i++) {
            for (int j = 0; j < goal[i].length; j++) {
                if (goal[i][j] != puzzle[i][j]) {
                    cost++;
                }
            }
        }
        return cost;
    }

    public static int euclideanDistanceHeuristic(int[][] goal, int[][] puzzle) {
        int cost = 0;

        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                int piece = puzzle[i][j];

                for (int a = 0; a < goal.length; a++) {
                    for (int b = 0; b < goal[a].length; b++) {
                        if (piece == goal[a][b]) { 
                            cost += Math.sqrt(Math.pow(b - j, 2) + Math.pow(a - i, 2));
                        }
                    }
                }
            }
        }
        return cost;
    }
}