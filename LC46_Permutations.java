package practise.src.main.java.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LC46_Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (Integer num : nums) {
            if (current.contains(num))
                continue;
            current.add(num);
            backtrack(nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}
