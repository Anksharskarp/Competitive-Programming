## USACO Training and Test Solutions
USACO Code (all written in Java)

## Solution Format
- The code needs to have a comment on the above listing that includes
  your USACO ID (aerialc1), the language (JAVA), and the task that you 
  were delegated to complete.
- Use BufferedReader, PrinterWriter, and StringTokenizer
- Make sure you use the correct inputs!
- Below is a sample submission:


    /*
    ID: your_id_here
    LANG: JAVA
    TASK: Example
    */
    import java.io.*;
    import java.util.*;
    
    class Example {
        public static void main (String [] args) throws IOException {
            // Use BufferedReader rather than RandomAccessFile; it's much faster
            BufferedReader f = new BufferedReader(new FileReader("Example.in"));
            // input file name goes above
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Example.out")));
            // Use StringTokenizer vs. readLine/split -- lots faster
            StringTokenizer st = new StringTokenizer(f.readLine());
            // Get line, break into tokens
            int i1 = Integer.parseInt(st.nextToken());    // first integer
            int i2 = Integer.parseInt(st.nextToken());    // second integer
            out.println(i1+i2);                           // output result
            out.close();                                  // close the output file
        }
    }