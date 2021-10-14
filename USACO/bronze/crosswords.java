package bronze;

/*
ID: anksharskarp
LANG: JAVA
TASK: crosswords
*/
import java.io.*;
import java.util.*;

class crosswords {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("crosswords.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crosswords.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int i1 = Integer.parseInt(st.nextToken());    // first integer
        int i2 = Integer.parseInt(st.nextToken());    // second integer
        out.println(i1+i2);                           // output result
        out.close();                                  // close the output file
    }
}
