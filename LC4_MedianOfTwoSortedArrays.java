package practise.leetCode;

import java.util.Arrays;

public class LC4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Integer[] nums1 = {1,3}, nums2 = {2,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    private static double findMedianSortedArrays(Integer[] nums1, Integer[] nums2) {
        Integer[] out = new Integer[nums1.length + nums2.length];
        int j=0;
        for(int i = 0; i < nums1.length ; i++)
            out[j++] = nums1[i];
        for(int i = 0; i < nums2.length ; i++)
            out[j++] = nums2[i];

        Arrays.sort(out);
        int length = out.length / 2;
        if (out.length % 2 != 0)
            return out[length];
        else
            return (double) (out[length] + out[length - 1]) / 2;
    }
}
