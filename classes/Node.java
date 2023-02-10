package classes;

public class Node {
    public Node(Problem p) {
        state = p;
        parent = null;
    }

    public Node parent;
    public Node[] children;
    public Problem state;
}