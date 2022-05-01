package JavaClass36;

import java.util.ArrayList;



public class Delimiters  {
    /** The open and close delimiters.
     *
     */
    private final String openDelimiter;
    private final String closeDelimiter;

    /** Constructs a Delimiters object where open is the open delimiter and close is the
     * close delimiter.
     * Precondition: open and close are non-empty strings.
     */
    public Delimiters(String open, String close)
    {
        openDelimiter = open;
        closeDelimiter = close;
    }

    /** Returns an ArrayList of delimiters from the array tokens, as described in part (a).
     *  Part (a.)
     */
    public ArrayList<String> getDelimitersList(String[] tokens) {
        ArrayList<String> delimiterList = new ArrayList<String>();

        for ( int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals(openDelimiter) || tokens[i].equals(closeDelimiter)) {
                delimiterList.add(tokens[i]);
            }
        }
        return delimiterList;
    }

    /** Returns true if the delimiters are balanced and false otherwise, as described in part (b).
     *  Precondition: delimiters contains only valid open and close delimiters.
     *  Part (b.)
     *  Example: "(()))(" is not balanced.
     */
    public boolean isBalanced(ArrayList<String> delimiters) {
        // There may be instance variables, constructors, and methods that are not shown.
        int numOpen = 0;
        int numClose = 0;

        for(int i = 0; i < delimiters.size(); i++) {
            if(delimiters.get(i).equals(openDelimiter)) {
                numOpen++;
            }
            if(delimiters.get(i).equals(closeDelimiter)) {
                numClose++;
            }
            if(numClose > numOpen) {
                return false;
            }
        }
        return numOpen == numClose;
    }
}

