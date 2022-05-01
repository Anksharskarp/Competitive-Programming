package advanced.Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Full solution to Problem 2
 */

public class B {

    /*  You can prove that the most optimized way to raise/lower the temperature is to raise the temperature of
     *  a group of cells that are positive or negative by min(cells) for positive and max(cells) for negative
     */

    static int[] change;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int cows = Integer.parseInt(st.nextToken());
        int[] prefer = new int[cows];
        int[] actual = new int[cows];
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < cows; i++) {
            prefer[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < cows; i++) {
            actual[i] = Integer.parseInt(st.nextToken());
        }
        change = new int[cows];
        for (int i = 0; i < cows; i++) {
            change[i] = prefer[i] - actual[i];
        }

        int ans = 0;
        // Iterate to find consecutive values that are positive/negative for change array
        // Then add to ans the greatest/least val in those values

        // Checks if all cells are at desired temperature
        while (check()) {
            int lastTrend = 0;
            // Keeps track of where the trend started so that it can change the values
            int lastExVal = 0;
            // This keep track of the min/max of the current trend (Stands for Last Extreme Value)
            int trend = 0;
            // trends: 1 = positive trend, 0 = neutral trend, -1 = negative trend

            for (int i = 0; i < change.length; i++) {

                // If val is positive
                if (change[i] > 0) {
                    if (trend == 1) {
                        //System.err.println("Continuing Positive Trend at " + i);
                        if (change[i] < lastExVal)
                            lastExVal = change[i];
                    }
                    if (trend != 1) {
                        //System.err.println("Starting Positive Trend at " + i);
                        ans += Math.abs(lastExVal);
                        for (; lastTrend < i; lastTrend++) {
                            change[lastTrend] += Math.abs(lastExVal);
                        }
                        trend = 1;
                        lastTrend = i;
                        lastExVal = change[i];
                    }
                    if (i == change.length-1) {
                        //System.err.println("At end of array");
                        ans += Math.abs(lastExVal);
                        for (; lastTrend < change.length; lastTrend++) {
                            change[lastTrend] -= Math.abs(lastExVal);
                        }
                    }

                    // If value is negative (Code nearly identical to positive if statement)
                } else if (change[i] < 0) {
                    if (trend == -1) {
                        //System.err.println("Continuing Negative Trend at " + i);
                        if (change[i] > lastExVal)
                            lastExVal = change[i];
                    }
                    if (trend != -1){
                        //System.err.println("Starting Negative Trend at " + i);
                        ans += Math.abs(lastExVal);
                        for (; lastTrend < i; lastTrend++) {

                            if (trend == 1)
                                change[lastTrend] -= Math.abs(lastExVal);
                        }
                        trend = -1;
                        lastTrend = i;
                        lastExVal = change[i];
                    }
                    if (i == change.length - 1) {
                        ans += Math.abs(lastExVal);
                        for (; lastTrend < change.length; lastTrend++) {
                            change[lastTrend] += Math.abs(lastExVal);
                        }
                    }

                    // If value is 0
                } else {
                    //System.err.println("0 at " + i);
                    for (; lastTrend < i; lastTrend++) {
                        if (trend == 1) {
                            change[lastTrend] -= Math.abs(lastExVal);
                        }
                        else if (trend == -1) {
                            change[lastTrend] += Math.abs(lastExVal);
                        }
                    }
                    ans += Math.abs(lastExVal);
                    lastTrend = i;
                    trend = 0;
                    lastExVal = 0;
                }
            }
        }
        pw.println(ans);
        pw.close();
    }

    // Checks if all cells are at desired temperature
    public static boolean check()
    {
        for (int i : change) {
            if (i != 0)
                return true;
        }
        return false;
    }
}
