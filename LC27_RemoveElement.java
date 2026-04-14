package practise.leetCode.pushedToGit;

public class LC27_RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    private static int removeElement(int[] nums, int val) {
        int ptr = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[ptr++] = nums[i];
            }
        }
        return ptr;
    }
}
