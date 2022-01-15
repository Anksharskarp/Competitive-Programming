package advanced.Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * This is an O(n^2) solution, it is possible to do in O(n) and therefore this solution would receive a tle on #11
 * Every other case passes for Problem 1
 */

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int cows = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        String line = st.nextToken();

        long ans = 0;
        long[] cowsG = new long[cows + 1];
        long[] cowsH = new long[cows + 1];
        for (int i = 1; i <= cows; i++)
        {
            if (line.charAt(i - 1) == 'G')
                ++cowsG[i];
            else
                ++cowsH[i];
        }
        for (int i = 1; i < cows+1; i++) {
            cowsG[i] += cowsG[i - 1];
            cowsH[i] += cowsH[i - 1];
        }
        boolean[] photos = new boolean[cows+1];

        for (int i = 3; i <= cows; i++)
        {
            photos[i] = true;
        }

        for (int i = 3; i <= cows; i++)
        {
            for (int j = i; j <= cows; j++) {
                if (photos[j]) {
                    long g = cowsG[j] - cowsG[j - i];
                    long h = cowsH[j] - cowsH[j - i];
                    if (g == 1 || h == 1) {
                        ans++;
                    } else {
                        photos[i] = false;
                    }
                }
            }
        }
        pw.println(ans);
        pw.close();
    }
}
