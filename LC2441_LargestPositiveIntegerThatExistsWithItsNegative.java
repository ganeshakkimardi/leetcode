package practise.leetCode;

import java.util.HashSet;
import java.util.Set;

public class LC2441_LargestPositiveIntegerThatExistsWithItsNegative {
    public static void main(String[] args) {
        int[] nums = {-1,2,-3,3,4};
        System.out.println(findMaxK(nums));
    }
    public static int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }
        int max = -1;
        for(int num : nums) {
            if(num > 0 && set.contains(-num)) {
                max = Math.max(max, num);
            }
        }
        return max;
    }
}
