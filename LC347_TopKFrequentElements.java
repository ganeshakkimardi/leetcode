package practise.leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class LC347_TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        int[] out = topKFrequent(nums, k);
        Arrays.stream(out).forEach(System.out::println);
    }

    private static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) return nums;
        int[] out = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int a : map.keySet())
            queue.offer(a);

        while(k != 0) {
            out[k - 1] = queue.poll();
            k--;
        }
        return out;
    }
}
