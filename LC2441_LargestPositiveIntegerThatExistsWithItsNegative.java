package practise.leetCode;

import java.util.Arrays;

public class LC2441_LargestPositiveIntegerThatExistsWithItsNegative {
    public static void main(String[] args) {
        int[] nums = {-1,2,-3,3,4};
        System.out.println(findMaxK(nums));
    }
    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;

        while (i < j && nums[i] < 0 && nums[j] > 0) {
            int sum = nums[i] + nums[j];

            if (sum == 0) {
                return nums[j];
            } else if (sum < 0) {
                i++;
            } else {
                j--;
            }
        }
        return -1;
    }
}
