package practise.leetCode;

public class LC42_TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int out = 0, length = height.length;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];
        int[] minLandR = new int[length];
        int[] diff = new int[length];

        int max = height[0];
        for (int i = 0; i < length; i++) {
            maxLeft[i] = max;
            max = Math.max(max, height[i]);
        }
        max = height[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            maxRight[i] = max;
            max = Math.max(max, height[i]);
        }

        for (int i = 0; i < length; i++) {
            minLandR[i] = Math.min(maxLeft[i], maxRight[i]);
            diff[i] = minLandR[i] - height[i];
            if(diff[i] >= 0)
                out += diff[i];
        }
        return out;
    }
}
