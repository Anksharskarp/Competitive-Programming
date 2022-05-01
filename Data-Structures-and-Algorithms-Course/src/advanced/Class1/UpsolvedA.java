package advanced.Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * O(n) solution to Problem 1
 */

public class UpsolvedA {

    /*  You can track the number of Guernsey between the Holsteins
     *  Then the ans is just the number of combinations such that "GGH", "GHG", or "HGG"
     *  Set # of Guernsey before one Holstein as x1 and # of Guernsey after that Holstein as x2
     *  Then the number of lonely photos including that Holstein is
     *  "GGH" = x1 - 1
     *  "GHG" = x1 * x2
     *  "HHG" = x2 - 1
     *  Sum all these values for all Holsteins and repeat the steps above except that instead of
     *  tracking the number of Guernsey between the Holsteins track the vice versa and add the values
     *
     */

    public static void main (String[] args) throws IOException {
        // input
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(r.readLine());
        String str = r.readLine();

        // The spaces between the Guernsey
        ArrayList<Long> diffG = new ArrayList<>();
        ArrayList<Long> diffH = new ArrayList<>();
        long betG = 0; // between G
        long betH = 0; // between H
        for (int i = 0; i < n; i++)
        {
            if (str.charAt(i) == 'G')
            {
                diffG.add(betG);
                ++betH;
                betG = 0;
            } else {
                diffH.add(betH);
                ++betG;
                betH = 0;
            }

            if (i == n - 1) {
                diffG.add(betG);
                diffH.add(betH);
            }
        }

        long ans = 0;
        for (int i = 0; i < diffG.size() - 1; i++)
        {
            // HHG
            ans += Math.max(diffG.get(i) - 1, 0);
            // GHH
            ans += Math.max(diffG.get(i+1) - 1, 0);
            // HGH
            ans += diffG.get(i) * diffG.get(i+1);
        }
        for (int i = 0; i < diffH.size() - 1; i++)
        {
            // GGH
            ans += Math.max(diffH.get(i) - 1, 0);
            // HGG
            ans += Math.max(diffH.get(i+1) - 1, 0);
            // GHG
            ans += diffH.get(i) * diffH.get(i+1);
        }
        pw.println(ans);
        pw.close();
    }
}