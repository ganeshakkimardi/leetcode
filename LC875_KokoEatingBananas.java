package practise.leetCode;

import java.util.Arrays;

public class LC875_KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;

        for(int pile : piles)
            right = Math.max(right, pile);

        while (left < right) {
            int mid = (left + right) / 2;

            int hours = 0;

            for (int pile : piles)
                hours += (pile + mid - 1) / mid; // ceil(a / b) , - 1 cos take ex of 8 , 4

            if (hours <= h)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

}
