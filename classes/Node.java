package classes;

public class Node {
    public Node(Problem p) {
        state = p;
        parent = null;
        utility = 0;
    }

    public Node(Problem p, Node par, int cost) {
        state = p;
        parent = par;
        utility = cost;
    }

    public Node parent;
    public Node[] children;
    public Problem state;
    public int utility;
}