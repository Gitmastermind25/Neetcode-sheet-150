package arraysandhashing;

import java.util.*;

public class ValidAnagrams {

    public static boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }
        //normal way rather than using allzeros way
        for (int num : count) {
            if (num != 0) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        // Calling function
        boolean result = isAnagram(s, t);

        // Output
        System.out.println("Is Anagram: " + result);

        sc.close();
    }
}