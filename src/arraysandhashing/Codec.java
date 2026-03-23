package arraysandhashing;

import java.util.*;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // Append length + '#' + string
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            // Find the '#' delimiter
            while (s.charAt(j) != '#') j++;
            int length = Integer.parseInt(s.substring(i, j)); // get string length
            String str = s.substring(j + 1, j + 1 + length); // extract string
            result.add(str);
            i = j + 1 + length; // move to next
        }
        return result;
    }

    // Testing everything
    public static void main(String[] args) {
        Codec codec = new Codec();

        List<String> original = Arrays.asList("Hello", "World", "Java#Programming", "");
        System.out.println("Original List: " + original);

        String encoded = codec.encode(original);
        System.out.println("Encoded String: " + encoded);

        List<String> decoded = codec.decode(encoded);
        System.out.println("Decoded List: " + decoded);
    }
}