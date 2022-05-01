package JavaClass16;

public class Homework16Part2 {
    public static void main(String[] args) {
		String s = "mmmine";
		System.out.println("Original String: "+s);
        System.out.println("First unique character of the above: "+firstUniqueChar(s));
    }

    public static int firstUniqueChar(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
	}
 }
