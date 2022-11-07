/*
ID: anksharskarp
LANG: JAVA
TASK: marathon
*/
//SUCCESS

import java.io.*;
import java.util.*;

public class blocks {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        int n = Integer.parseInt(br.readLine());

        int[] frequencyTable = new int[26];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String t = st.nextToken();

            int[] optimized = getMaximumFrequency(s, t);
            add(frequencyTable, optimized);
        }

        PrintWriter pw = new PrintWriter(new FileWriter("blocks.out"));

        for (int i = 0; i < 26; i++) {
            pw.println(frequencyTable[i]);
        }

        pw.close();
        br.close();
    }

    public static int[] getMaximumFrequency(String s, String t) {
        int[] letterOne = getFrequency(s);
        int[] letterTwo = getFrequency(t);
        int[] letterIndexCollection = new int[26];
        for (int i = 0; i < 26; i++) {
            letterIndexCollection[i] = Math.max(letterOne[i], letterTwo[i]);
        }

        return letterIndexCollection;
    }

    public static int[] getFrequency(String s) {
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++)
            table[s.charAt(i) - 'a']++;
        return table;
    }

    //Sum of the values from the tables
    public static void add(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            a[i] += b[i];
        }
    }
}