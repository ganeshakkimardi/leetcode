package practise.src.main.java.leetCode;

import static javax.swing.Spring.height;

public class LC11_Container_With_Most_Water {
    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int area = 0, minHeight = 0, left = 0,  right = height.length - 1;

        while (left < right) {
            minHeight = Math.min(height[right], height[left]);
            area = Math.max(area, minHeight * (right - left));

            while (left < right && minHeight >= height[left]) left++;
            while (left < right && minHeight >= height[right]) right--;
        }
        return area;
    }
}
