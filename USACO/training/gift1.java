package training;/*
ID: aerialc1
LANG: JAVA
TASK: gift1
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

class gift1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gift1.in"));
        HashMap<String,Integer> map = new HashMap<String,Integer> ();
        int peopleCount = Integer.parseInt(br.readLine());
        String[] s = new String[peopleCount];
        for (int i=0; i<peopleCount; i++) {
            s[i] = br.readLine();
            map.put(s[i], 0);
        }
        for (int i=0;i<peopleCount;i++) {
            String giver = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int amount=Integer.parseInt(st.nextToken());
            int giveToCount = Integer.parseInt(st.nextToken());
            if (giveToCount>0) {
                amount = amount/giveToCount*giveToCount;
                map.put(giver, map.get(giver) - amount);
                amount /= giveToCount;
                for (int i2=0; i2<giveToCount; i2++) {
                    String receiver = br.readLine();
                    map.put(receiver, map.get(receiver) + amount);
                }
            }
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        for (int i=0;i<peopleCount;i++) {
            pw.print(s[i]);
            pw.print(" ");
            pw.println(map.get(s[i]));
        }
        pw.close();
    }
}
