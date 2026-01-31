package practise.src.main.java.leetCode;

public class LC169_MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {
        int count = 0, number = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                count++;
                number = nums[i];
            } else if(nums[i] == number)
                count++;
            else if(nums[i] != number) {
                count--;
            }
        }
        return number;
    }
}
