package practise.leetCode;

import java.util.*;

public class LC217_ContainsDuplicates {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i : nums) {
//            if(map.containsKey(i))
//                return true;
//            else
//                map.put(i,i);
//        }
//        return false;
//        int nums1[] = Arrays.stream(nums).sorted().distinct().toArray();
//        if(nums.length == nums1.length)
//            return false;
//        else
//            return true;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if(set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }
}
