package arraysandhashing;

import java.util.HashSet;
import java.util.Set;
class ContainsDuplicate {
    static boolean checkDuplicates(int[] arr) {
        int n = arr.length;

        // Create a HashSet to store the unique elements
        Set<Integer> entry = new HashSet<>();

        // Iterate through each element
        for (int i = 0; i < n; i++) {

            // If the element is already present, return true
            // Else insert the element into the set
            if (entry.contains(arr[i]))
                return true;
            else
                entry.add(arr[i]);
        }

        // If no duplicates are found, return false
        return false;
    }
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 0 };
        System.out.println(checkDuplicates(arr));
    }
}