package practise.src.main.java.leetCode;

import java.util.Arrays;

public class LC153_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,0,1,2,3};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = (l + r) / 2;
            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
