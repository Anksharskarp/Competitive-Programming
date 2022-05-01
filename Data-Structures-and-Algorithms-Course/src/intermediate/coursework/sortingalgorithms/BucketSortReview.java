package intermediate.coursework.sortingalgorithms;

import java.util.*;

//Demonstrates a bucket sort, specifically of the lexicographical type.
//Now includes complexity analysis (please see file comments)
public class BucketSortReview {

    //Performs a bucket sort on some words to arrange them in lexicographical (alphabetical) order.
    public static void wordSort(String[] words, int which) {
        //Declare the bucket and initialize them
        ArrayList<String>[] bucket = new ArrayList[27];
        for(int i = 0; i < 26; i++) {
            bucket[i] = new ArrayList(); //O(26)
        }
        //Sort according to the first letter using bucket sort (complexity of O(1))
        //bucket[0]: where all words whose length is less than 'which' go
        //Be careful; if a letter is uppercase instead of lowercase, the character values will be different,
        //and you will need to take that into account with the character values.
        //Complexity O(n)
        for (int i = 0; i < words.length; i++) {
            //Looks for the character that we are going to be sorting by (0 being the first character, 1 being the
            //second character, and so on so forth.
            int bucketKind;
            //If one word is shorter than the other, it is automatically put into the smallest bucket for
            //the short words.
            if(which >= words[i].length()) { //(O(1)
                bucketKind = 0;
            } else { //O(1)
                char c = words[i].charAt(which); //O(1)
                if (c >= 'a' && c <= 'z') { //O(1)
                    bucketKind = c - 'a'; //O(1)
                } else { //O(1)
                    bucketKind = c - 'A'; //O(1)
                }
            }
            bucket[bucketKind].add(words[i]);   //For each word, put it in the corresponding bucket. Complexity O(1)
        }
        int index = 0;
        for(int i = 0; i < 26; i++) {   //Put back the words from each bucket back into the array of words.
            for(int j = 0; j < bucket[i].size(); j++) {
                words[index++] = bucket[i].get(j);
            }
        }
    } //b[0].size() + b[1].size() + ... + 1 + ... + b[25].size()

    //Radix sort performs a bucket sort, arranging words in lexicographical order by comparing the characters
    //in backwards order (from the start to the end)
    public static void wordSortRadix(String[] words, int maxLength) {
        //Sorts by characters for words, except it's from the last character to the first character
        for(int i = maxLength - 1; i >= 0; i--) //O(n) = O(n)
            //for(int i = 0; i < maxLength; i++)
            wordSort(words, i); //d * O(n) = O(n * d) * O(20 * d) = O(n)
    }

    //Numerical sort performs a bucket sort, arranging numbers in lexicographical order by treating each digit as an
    //individual character, and ordering them based on the precedence of each of the characters (digits).
    //Our goal here is to set each numerical digit to a character value, then put each digit in its own corresponding
    //bucket, and "lexicographically" sort the digits from there on out.
    public static void numberSortRadix(int[] num) {

    }

    //Inputs an array of randomly arranged words to sort in lexicographical order.
    //If we are comparing two words, and one word is longer than the other, then the shorter word would automatically
    //get placed in the smaller bucket once we reach the end of the sorting process.
    public static void main(String[] args) {
        //Word Sort Radix Test
        String[] words = {"From", "Work", "Here", "Word", "Have", "From", "Chat", "cybersecurity", "Which", "Result", "foods", "food"};
        int maxCharacterCount = 0;
        for(int i = 0; i < words.length; i++) {
            if(maxCharacterCount < words[i].length()) {
                maxCharacterCount = words[i].length();
            }
        }
        System.out.println(Arrays.toString(words));
        // wordSort(words, i);
        wordSortRadix(words, maxCharacterCount);
        System.out.println(Arrays.toString(words));

        //Number Sort Radix Test
        int[] nums = {120, 30, 26, 12, 99, 100, 12, 1256};
    }
}
