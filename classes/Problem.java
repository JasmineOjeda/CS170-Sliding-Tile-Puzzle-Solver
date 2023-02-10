
package classes;

public class Problem {
    public Problem(int p[][]) {
        puzzle = p;
        findAsteriskLocation();
    }

    public int puzzle[][];
    public int asterisk_x;
    public int asterisk_y;

    public void findAsteriskLocation() {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                int piece = puzzle[i][j];
    
                if (piece == 0) {
                    asterisk_x = i;
                    asterisk_y = j;
                }
            }
        }
    }

    public boolean moveAsteriskUp() {
        if (asterisk_x != 0) {
            int temp_piece = puzzle[asterisk_x - 1][asterisk_y];
            puzzle[asterisk_x - 1][asterisk_y] = 0;
            puzzle[asterisk_x][asterisk_y] = temp_piece;

            findAsteriskLocation();
            return true;
        }
        return false;
    }

    public boolean moveAsteriskDown() {
        if (asterisk_x != (puzzle.length - 1)) {
            int temp_piece = puzzle[asterisk_x + 1][asterisk_y];
            puzzle[asterisk_x + 1][asterisk_y] = 0;
            puzzle[asterisk_x][asterisk_y] = temp_piece;

            findAsteriskLocation();
            return true;
        }
        return false;
    }

    public boolean moveAsteriskLeft() {
        if (asterisk_y != 0) {
            int temp_piece = puzzle[asterisk_x][asterisk_y - 1];
            puzzle[asterisk_x][asterisk_y - 1] = 0;
            puzzle[asterisk_x][asterisk_y] = temp_piece;

            findAsteriskLocation();
            return true;
        }
        return false;
    }

    public boolean moveAsteriskRight() {
        if (asterisk_y != (puzzle[0].length - 1)) {
            int temp_piece = puzzle[asterisk_x][asterisk_y + 1];
            puzzle[asterisk_x][asterisk_y + 1] = 0;
            puzzle[asterisk_x][asterisk_y] = temp_piece;

            findAsteriskLocation();
            return true;
        }
        return false;
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

    public boolean checkPuzzle() {
        int count = 1;
    
        if (puzzle[puzzle.length - 1][puzzle[0].length - 1] != 0) {
            return false;
        }
        else {
            for (int i = 0; i < puzzle.length; i++) {
                for (int j = 0; j < puzzle[i].length; j++) {
    
                    int piece = puzzle[i][j];
                    if ((puzzle.length - 1 == i) && (puzzle[0].length - 1 == j)) {
                        if (piece != 0) {
                            return false;
                        }
                    }
                    else if (piece != count) {
                        return false;
                    }
                    count++;
                }
            }
        }
    
        return true;
    }
}
