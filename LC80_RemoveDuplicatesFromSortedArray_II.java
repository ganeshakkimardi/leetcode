package practise.src.main.java.leetCode;

public class LC80_RemoveDuplicatesFromSortedArray_II {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicatesII(nums));
    }

    private static int removeDuplicatesII(int[] nums) {
        if(nums.length < 2) return nums.length;

        int j = 2;
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
