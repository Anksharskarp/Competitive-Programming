package anksharskarp.usaco.problemsandsolutions.training;
/*
ID: aerialc1
LANG: JAVA
TASK: friday
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class friday {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("friday.in"));
        int maxYear = 1900 + Integer.parseInt(br.readLine());
        int currentDay = 12; //%7 => Monday = 0, Tuesday = 1, Friday = 4, Sunday = 6
        int [] daysInLeapYears = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int [] daysInNormalYears = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int [] count = new int[7];

        for (int year = 1900; year < maxYear; year++) {
            for (int month = 0; month < 12; month++) {
                count[currentDay % 7]++;
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    currentDay += daysInLeapYears[month];
                } else {
                    currentDay += daysInNormalYears[month];
                }
            }
        }

        //display order.
        int [] seq = {5, 6, 0, 1, 2, 3, 4};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seq.length; i++) {
            sb.append(count[seq[i]]);
            sb.append(" ");
        }
        String s = sb.toString();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        pw.println(s.substring(0, s.length() - 1));
        pw.close();
        System.exit(0);
    }
}