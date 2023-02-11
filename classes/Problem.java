
package classes;

public class Problem {
    public int puzzle[][];
    public int goal[][];
    public int blank_x;
    public int blank_y;

    public Problem(int p[][]) {
        puzzle = new int[p.length][p[0].length];
        goal = new int[p.length][p[0].length];

        //INITIALIZATION: Deep copy p to puzzle
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                puzzle[i][j] = p[i][j];
            }
        }

        findBlankLocation();
        createGoal();
    }

    // INITIALIZATION: Find the location of the "Blank" tile
    public void findBlankLocation() {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                int piece = puzzle[i][j];
    
                if (piece == 0) {
                    blank_x = i;
                    blank_y = j;
                }
            }
        }
    }

    // INITIALIZATION: Create the goal state based on the dimensions of the Puzzle
    public void createGoal() {
        int count = 1;

        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if ((puzzle.length - 1 == i) && (puzzle[0].length - 1 == j)) {
                    goal[i][j] = 0;
                    return;
                }
                goal[i][j] = count;
                count++;
            }
        }
    }

    // PROBLEM OPERATIONS: Moving the "Blank" tile UP, LEFT, DOWN, or RIGHT
    public boolean moveBlankUp() {
        if (blank_x != 0) {
            int temp_piece = puzzle[blank_x - 1][blank_y];
            puzzle[blank_x - 1][blank_y] = 0;
            puzzle[blank_x][blank_y] = temp_piece;

            findBlankLocation();
            return true;
        }
        return false;
    }

    public boolean moveBlankDown() {
        if (blank_x != (puzzle.length - 1)) {
            int temp_piece = puzzle[blank_x + 1][blank_y];
            puzzle[blank_x + 1][blank_y] = 0;
            puzzle[blank_x][blank_y] = temp_piece;

            findBlankLocation();
            return true;
        }
        return false;
    }

    public boolean moveBlankLeft() {
        if (blank_y != 0) {
            int temp_piece = puzzle[blank_x][blank_y - 1];
            puzzle[blank_x][blank_y - 1] = 0;
            puzzle[blank_x][blank_y] = temp_piece;

            findBlankLocation();
            return true;
        }
        return false;
    }

    public boolean moveBlankRight() {
        if (blank_y != (puzzle[0].length - 1)) {
            int temp_piece = puzzle[blank_x][blank_y + 1];
            puzzle[blank_x][blank_y + 1] = 0;
            puzzle[blank_x][blank_y] = temp_piece;

            findBlankLocation();
            return true;
        }
        return false;
    }

    public boolean checkGoal() {
        return puzzleEquals(goal);
    }

    public boolean puzzleEquals(int[][] other) {
         for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if (puzzle[i][j] != other[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void displayPuzzle() {
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
    }
}
