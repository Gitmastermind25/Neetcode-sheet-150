package twopointers;

import java.util.*;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // take full line input
        String input = sc.nextLine();

        // split by space
        String[] parts = input.trim().split("\\s+");

        int[] height = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            height[i] = Integer.parseInt(parts[i]);
        }

        TrappingRainWater obj = new TrappingRainWater();
        System.out.println(obj.trap(height));
    }
}