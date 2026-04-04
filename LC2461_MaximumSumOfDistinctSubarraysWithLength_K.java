package practise.src.main.java.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC2461_MaximumSumOfDistinctSubarraysWithLength_K {
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }

    private static long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        long sum = 0, maxSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            // Remove elements until nums[right] is unique
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            // Add current element
            set.add(nums[right]);
            sum += nums[right];

            // Check window size
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);

                // Slide window
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
