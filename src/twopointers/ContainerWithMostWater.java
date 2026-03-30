package twopointers;

import java.util.*;

public class ContainerWithMostWater {

    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = 0;

        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            res = Math.max(res, area);

            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter heights (space separated):");
        String input = sc.nextLine();

        String[] parts = input.split(" ");
        int[] heights = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            heights[i] = Integer.parseInt(parts[i]);
        }

        ContainerWithMostWater obj = new ContainerWithMostWater();
        int result = obj.maxArea(heights);

        System.out.println("Maximum water: " + result);

        sc.close();
    }
}