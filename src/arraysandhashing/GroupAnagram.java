package arraysandhashing;

import java.util.*;

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append('#'); // separator
                sb.append(num);
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // Hardcoded input
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        GroupAnagram sol = new GroupAnagram();
        List<List<String>> result = sol.groupAnagrams(strs);

        System.out.println("Grouped anagrams: " + result);
    }
}
