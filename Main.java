import classes.Problem;
import classes.Node;
import classes.Graph;

class Main {
    public static void main(String args[]) {
        //int p[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int p[][] = {{1, 2, 5}, {4, 0, 3}, {7, 8, 6}};

        Graph graph = new Graph(new Node(new Problem(p)));
        Problem test = graph.root.state;

        do {
            test.displayPuzzle();
            System.out.print("\n");
        } while (test.moveAsteriskUp());
        
        System.out.println("SUCCESS");
    }
}