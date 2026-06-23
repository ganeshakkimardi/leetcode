package practise.leetCode;

import java.util.HashMap;

public class LC525_ContiguousArray {
    public static void main(String[] args) {
        int nums[] = {0,1,1,1,1,1,0,0,0};
        System.out.println(findMaxLength(nums));
    }
    public static int findMaxLength(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0) nums[i] = -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0 , -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else
                map.put(sum, i);
        }
        return res;
    }
}
