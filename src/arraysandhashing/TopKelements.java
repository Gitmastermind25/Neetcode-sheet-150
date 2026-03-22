package arraysandhashing;

import java.util.*;

public class TopKelements {

    // Function to find top K frequent elements
    public static int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Frequency map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket array (index = frequency)
        List<Integer>[] bucket = new ArrayList[n + 1];

        // Initialize buckets
        for (int i = 0; i <= n; i++) {
            bucket[i] = new ArrayList<>();
        }

        // Fill buckets
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int freq = entry.getValue();
            bucket[freq].add(element);
        }

        // Step 3: Collect top K elements
        List<Integer> result = new ArrayList<>();

        for (int i = n; i >= 0 && k > 0; i--) {
            for (int num : bucket[i]) {
                result.add(num);
                k--;
                if (k == 0) break;
            }
        }

        // Convert List to array
        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }

        return resArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: size of array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input: array elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input: value of k
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        // Call function
        int[] result = topKFrequent(nums, k);

        // Output result
        System.out.println("Top " + k + " frequent elements:");
        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}