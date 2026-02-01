package practise.src.main.java.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC229_MajorityElement_II {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        List<Integer> out = majorityElement_II(nums);
        out.stream().forEach(System.out::println);
    }

    private static List<Integer> majorityElement_II(int[] nums) {
        Map<Integer, Integer> elementCountMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            elementCountMap.put(nums[i], elementCountMap.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> majorityElements = new ArrayList<>();
        int threshold = nums.length / 3;

        for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();

            if (count > threshold) {
                majorityElements.add(element);
            }
        }
        return majorityElements;
    }
}
