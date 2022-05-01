package advanced.Class1;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Full solution to Problem 3
 */

public class C {

    static ArrayList<Integer> permutation;
    // 0-indexed
    static HashMap<Point, Boolean> haybales;
    static int ans = 0;
    static int downsLeft;
    static int rightsLeft;
    static Point curr = new Point(0, 0);
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        // input
        int cases = Integer.parseInt(st.nextToken());
        for (int i = 0; i < cases; i++)
        {
            permutation = new ArrayList<>();
            haybales = new HashMap<>();

            st = new StringTokenizer(r.readLine());
            int grid = Integer.parseInt(st.nextToken());
            int turn = Integer.parseInt(st.nextToken());
            for (int j = 0; j < grid; j++)
            {
                st = new StringTokenizer(r.readLine());
                String str = st.nextToken();
                for (int col = 0; col < grid; col++) {
                    if (str.charAt(col) == '.')
                        haybales.put(new Point(col, j), false);
                    else
                        haybales.put(new Point(col, j), true);
                }
            }
            downsLeft = grid-1;
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
        // Add 1
        if (rightsLeft - 1 >= 0) {
            permutation.add(1);
            curr.x++;
            if (permutation.size() >= 2) {
                if (!permutation.get(permutation.size() - 2).equals(permutation.get(permutation.size() - 1)))
                    ++turns;
            }
            //System.err.println(curr.x + ", " + curr.y);
            --rightsLeft;

            // check if this hits haybale
            if (!haybales.get(curr)) {
                // check if number of turns is acceptable
                if (turns <= maxTurns)
                    search(size, maxTurns, turns);
            }
            ++rightsLeft;

            if (permutation.size() >= 2) {
                if (!permutation.get(permutation.size() - 2).equals(permutation.get(permutation.size() - 1)))
                    --turns;
            }
            permutation.remove(permutation.size() - 1);
            curr.x--;
        }

        // Add 0
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
            if (!haybales.get(curr)) {
                // check if number of turns is acceptable
                if (turns <= maxTurns)
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
