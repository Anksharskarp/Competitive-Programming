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

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crosswords.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());

        int i1 = Integer.parseInt(st.nextToken());
        int i2 = Integer.parseInt(st.nextToken());
        out.println(i1+i2);
        out.close();
    }
}
