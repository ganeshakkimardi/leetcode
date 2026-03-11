package practise.leetCode;

import java.util.Arrays;

public class LC189_RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
    }
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int[] rotated = new int[len];
        for(int i = 0; i < len; i++) {
            rotated[(i + k) % len] = nums[i];
        }

        for(int i = 0; i < len; i++)
            nums[i] = rotated[i];

        Arrays.stream(nums).forEach(System.out::println);
    }
}
