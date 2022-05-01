package JavaClass36;

/*
Homework36Part2:

Question:
The LightBoard class models a two-dimensional display of lights, where each light is either on or off, as represented
by a Boolean value. You will implement a constructor to initialize the display and a method to evaluate a light.
 */

// There may be additional instance variables, constructors, and methods not shown.
public class LightBoard {

    /**
     * The lights on the board, where true represents on and false represents off.
     */
    private final boolean[][] lights;

    /**
     * Constructs a LightBoard object having numRows rows and numCols columns.
     * Precondition: numRows > 0, numCols > 0
     * Postcondition: each light has a 40% probability of being set to on.
     * Part (a.)
     */
    public LightBoard(int numRows, int numCols) {
        lights = new boolean[numRows][numCols];

        for(int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                double b = Math.random();
                lights[i][j] = b <= 0.4;
            }
        }
    }

    /**
     * Evaluates a light in row index row and column index col and returns a status
     * as described in part (b).
     * Precondition: row and col are valid indexes in lights.
     * Part (b.)
     */
    public boolean evaluateLight(int row, int col) {
        int onCount = 0;
        for(int i = 0; i < lights.length; i++) {
            if(lights[i][col]) {
                onCount++;
            }
        }

        if(lights[row][col]) {
            if(onCount % 2 == 0) {
                return false;
            }
        } else if(onCount % 3 == 0) {
            return true;
        }
        return lights[row][col];
    }

}




