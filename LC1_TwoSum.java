package practise.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LC1_TwoSum {
    public static void main(String[] args) {
        int nums[] = {3,3}, target = 6;
        int index[] = twoSum(nums, target);
        for (int i: index)
            System.out.println(i);
    }

    private static int[] twoSum(int[] nums, int target) {
        int rem, i;
        Map<Integer, Integer> map = new HashMap<>();
        for (i = 0; i < nums.length; i++) {
            rem = target - nums[i];
            if(map.containsKey(rem)){
//                System.out.println("[" + map.get(rem) + "," + i + "]");
                return new int[] {map.get(rem), i};
            } else
                map.put(nums[i], i);
        }
        return new int[] {};
    }
}
