package intermediate.coursework.strings;

public class ConvertingBetweenStringsAndCharacterArrays {
    public static void main(String[] args) {
        /*
        Given a string S, we can create a new character array matching S by using the method, S.toCharArray();
         */
        String exampleString = "programming";
        char[] exampleCharArray = exampleString.toCharArray();

        /*
        For example, if S = "bird", the method char[] A = S.toCharArray() returns the character array:
        A = {'b', 'i', 'r', 'd'}.

        Conversely, there is a form of the String constructor that accepts a character array as a parameter.
        For example, with character array A = {'b', 'i', 'r', 'd'}, the code:

        String comsolidatedWord = new String(A);

        produces "bird".
         */
    }
}
