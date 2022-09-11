//SUCCESS
import java.util.*;
import java.io.*;

public class paint {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("paint");

        int a = io.nextInt();
        int b = io.nextInt();
        int c = io.nextInt();
        int d = io.nextInt();

        int[] cover = new int[100];
        for (int i = a; i < b; i++) {
            cover[i] = 1;
        }
        for (int i = c; i < d; i++) {
            cover[i] = 1;
        }

        int ans = 0;
        for (int i = 0; i < cover.length; i++) {
            ans += cover[i];
        }
        io.println(ans);
        io.close();
    }

    static class Kattio extends PrintWriter {
        private final BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(new FileWriter(problemName + ".out"));
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
