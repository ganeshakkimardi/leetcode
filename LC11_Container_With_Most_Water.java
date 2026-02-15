package practise.leetCode;

public class LC11_Container_With_Most_Water {
    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        int minHeight, width, area;
        while(left < right) {
            minHeight = Math.min(height[left], height[right]);
            width = right - left;
            area = minHeight * width;

            maxArea = Math.max(area, maxArea);

            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
