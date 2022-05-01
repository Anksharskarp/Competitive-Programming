package intermediate.coursework.Class13;

import java.util.*;

//Demonstrates a bucket sort, specifically of the lexicographical type.
public class LexicographicalBucketSortDemo {

    //Performs a bucket sort on some words to arrange them in lexicographical (alphabetical) order.
    public static void wordSort(String[] words, int which) {
        //Declare the bucket and initialize them
        ArrayList<String>[] bucket = new ArrayList[27];
        for(int i = 0; i < 26; i++) {
            bucket[i] = new ArrayList();
        }
        //Sort according to the first letter using bucket sort
        //bucket[0]: where all words whose length is less than 'which' go
        //Be careful; if a letter is uppercase instead of lowercase, the character values will be different,
        //and you will need to take that into account with the character values.
        for (int i = 0; i < words.length; i++) {
            //Looks for the character that we are going to be sorting by (0 being the first character, 1 being the
            //second character, and so on so forth.
            int bucketKind;
            //If one word is shorter than the other, it is automatically put into the smallest bucket for
            //the short words.
            if(which >= words[i].length()) {
                bucketKind = 0;
            } else {
                char c = words[i].charAt(which);
                if (c >= 'a' && c <= 'z') {
                    bucketKind = c - 'a';
                } else {
                    bucketKind = c - 'A';
                }
            }
            bucket[bucketKind].add(words[i]);   //For each word, put it in the corresponding bucket.
        }
        int index = 0;
        for(int i = 0; i < 26; i++) {   //Put back the words from each bucket back into the array of words.
            for(int j = 0; j < bucket[i].size(); j++) {
                words[index++] = bucket[i].get(j);
            }
        }
    }

    //Radix sort performs a bucket sort, arranging words in lexicographical order by comparing the characters
    //in backwards order (from the start to the end)
    public static void wordSortRadix(String[] words, int maxLength) {
        //Sorts by characters for words, except it's from the last character to the first character
        for(int i = maxLength - 1; i >= 0; i--)
            //for(int i = 0; i < maxLength; i++)
                wordSort(words, i);
    }

    //Inputs an array of randomly arranged words to sort in lexicographical order.
    //If we are comparing two words, and one word is longer than the other, then the shorter word would automatically
    //get placed in the smaller bucket once we reach the end of the sorting process.
    public static void main(String[] args) {
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
    }
}