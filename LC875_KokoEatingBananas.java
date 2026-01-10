package practise.leetCode;

import java.util.Arrays;

public class LC875_KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = Arrays.stream(piles).max().getAsInt();
        int ans = max;
        while (min <= max) {
            int mid = (min + max) / 2;
            long hours = 0;

            for (int pile : piles) {
                hours = hours + (pile + mid - 1) / mid;
            }

            if (hours <= h) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }

}
