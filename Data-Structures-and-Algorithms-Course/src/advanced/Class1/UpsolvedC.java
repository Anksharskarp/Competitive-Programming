package advanced.Class1;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Full solution to Problem 3
 */

public class UpsolvedC {

    /* The resulting answer will be the # of permutations of "R" and "D" (Representing Bessie going right and down
     * as those are the only directions) that satisfies the following conditions:
     *  1. The path does not intersect a haybale
     *  2. The path turns at most K times
     *
     * Just pruning the search based on that criteria will still result in a tle on the last few cases, so
     * you can prune the search further where if Bessie cannot turn anymore and is not on the last row/column,
     * then you can stop the search there for that path
     *
     * So prune all the following:
     *  1. The path does intersect a haybale
     *  2. The path turns more than K times
     *  3. The path turns K times and is not on the last row/column
     */

    static ArrayList<Integer> permutation = new ArrayList<>();
    // 0-indexed

    // Tracks whether that location is a haybale or not
    static boolean[][] haybales;

    static int ans = 0;

    // How many times Bessie can continue going down or right (updated during recursion)
    static int downsLeft;
    static int rightsLeft;

    // Where Bessie currently is at (updated during recursion)
    static Point curr = new Point(0, 0);

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int cases = Integer.parseInt(st.nextToken());

        for (int i = 0; i < cases; i++)
        {
            st = new StringTokenizer(r.readLine());
            int grid = Integer.parseInt(st.nextToken());
            int turn = Integer.parseInt(st.nextToken());
            haybales = new boolean[grid][grid];
            for (int j = 0; j < grid; j++)
            {
                st = new StringTokenizer(r.readLine());
                String str = st.nextToken();
                for (int col = 0; col < grid; col++) {
                    haybales[col][j] = str.charAt(col) != '.';
                }
            }

            downsLeft = grid - 1;
            rightsLeft = grid - 1;

            // generate all permutations
            search(2*(grid-1), turn, 0);
            pw.println(ans);
            ans = 0;
        }
        pw.close();
    }

    // generate all permutations
    // 1 = right, 0 = down
    public static void search(int size, int maxTurns, int turns)
    {
        // check if bessie made it to barn
        if (permutation.size() == size) {
            ++ans;
            return;
        }
        // Add 1 (Bessie goes right)
        if (rightsLeft - 1 >= 0) {
            permutation.add(1);
            curr.x++;

            // Checks if this is a turn
            if (permutation.size() >= 2) {
                if (!permutation.get(permutation.size() - 2).equals(permutation.get(permutation.size() - 1)))
                    ++turns;
            }
            //System.err.println(curr.x + ", " + curr.y);
            --rightsLeft;

            // check if this hits haybale
            if (!haybales[curr.y][curr.x]) {
                // check if number of turns is acceptable
                if (turns <= maxTurns - 1)
                    search(size, maxTurns, turns);

                    // check if the path turns K times and is on the last column
                else if (turns == maxTurns && downsLeft == 0)
                    search(size, maxTurns, turns);
            }

            // reset everything
            ++rightsLeft;

            if (permutation.size() >= 2) {
                if (!permutation.get(permutation.size() - 2).equals(permutation.get(permutation.size() - 1)))
                    --turns;
            }
            permutation.remove(permutation.size() - 1);
            curr.x--;
        }

        // Add 0 (Bessie goes down)
        // This is a literal copy of the first big if statement except the up/downs are swapped
        if (downsLeft - 1 >= 0) {
            permutation.add(0);
            curr.y++;
            if (permutation.size() >= 2) {
                if (!permutation.get(permutation.size() - 2).equals(permutation.get(permutation.size() - 1)))
                    ++turns;
            }
            // check if this hits haybale
            downsLeft--;
            //System.err.println(curr.x + ", " + curr.y);
            if (!haybales[curr.y][curr.x]) {
                // check if number of turns is acceptable
                if (turns <= maxTurns - 1)
                    search(size, maxTurns, turns);
                else if (turns == maxTurns && rightsLeft == 0)
                    search(size, maxTurns, turns);
            }
            downsLeft++;
            if (permutation.size() >= 2) {
                if (!permutation.get(permutation.size() - 2).equals(permutation.get(permutation.size() - 1)))
                    --turns;
            }
            permutation.remove(permutation.size() - 1);
            curr.y--;
        }
    }
}