## USACO Training and Test Solutions
USACO Code (all written in Java)

### Solution Format
- The code needs to have a comment on the above listing that includes
  your USACO ID (aerialc1), the language (JAVA), and the task that you 
  were delegated to complete.
- Use BufferedReader, PrinterWriter, and StringTokenizer
- Make sure you use the correct and necessary imports!
- Below is a sample submission:


    /*
    ID: aerialc1
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

Hopefully this above example is useful.

###Final Tips
- In general, it's an excellent idea to use pseudocode and flowcharts, combined with 
careful reading and attention to detail to solve problems.
- If you get discouraged because the problems are hard, read this excerpt from the official
USACO Training Pages to boost your morale:
  
    - "_Different people will take different spans of time to move through this material, especially the 100+ programming 
    challenges. Some students already have years and years of experience, perhaps even at the international level. Others 
    are just beginning to compete. **Any rate much lower than one problem per two weeks is probably not high enough to achieve
    a rewarding training effect. It is anticipated some of the best students will average one problem or more per day for 
    the first two sections (slower after that).** To get the most out of this website, you should **solve the problems in 
    order, understand each paragraph of the instructional texts, and digest the analyses to see how they apply to 
    solutions.** Feel free to improve your solution after you read the analysis. Furthermore, feel free to send us 
    new or better analyses if you have them._"