package slidingwindow;

import java.util.*;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int res = 0;
        HashSet<Character> charSet = new HashSet<>();

        for (char c : s.toCharArray()) {
            charSet.add(c);
        }

        for (char c : charSet) {
            int count = 0, l = 0;

            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) == c) {
                    count++;
                }

                while ((r - l + 1) - count > k) {
                    if (s.charAt(l) == c) {
                        count--;
                    }
                    l++;
                }

                res = Math.max(res, r - l + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string:");
        String s = sc.nextLine();

        System.out.println("Enter k:");
        int k = sc.nextInt();

        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
        int result = obj.characterReplacement(s, k);

        System.out.println("Longest length: " + result);

        sc.close();
    }
}