package classes;

public class Graph {
    public Node root;
    
    public Graph(Node n) {
        root = n;
    }

    public void displayGraph() {
        displayGraph(root);
    }

    public void displayGraph(Node n) {
        n.state.displayPuzzle();

        for (int i = 0; i < n.children.size(); i++) {
            displayGraph(n.children.get(i));
        }
    }
}
