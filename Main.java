import classes.Problem;
import classes.Node;
import classes.Graph;

class Main {
    public static void main(String args[]) {
        //int p[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int p[][] = {{1, 2, 5}, {4, 0, 3}, {7, 8, 6}};

        Graph graph = new Graph(new Node(new Problem(p)));
        Problem test = graph.root.state;

        //System.out.println(test.checkGoal());
        /*
        do {
            test.displayPuzzle();
            System.out.print("\n");
        } while (test.moveAsteriskUp());
        */
        displayPuzzle(test.puzzle);
        Problem new_p = new Problem(graph.root.state.puzzle);

        new_p.moveBlankUp();
        displayPuzzle(new_p.puzzle);
        test.moveBlankDown();
        displayPuzzle(test.puzzle);
        System.out.println(test.puzzleEquals(new_p.puzzle));
    }

    public static void displayPuzzle(int[][] puzzle) {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                int piece = puzzle[i][j];
    
                if (piece == 0) {
                    System.out.print("* ");
                }
                else {
                    System.out.print(piece + " ");
                }
            }
                    
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}