package practise.src.main.java.leetCode;

public class LC1423_MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }

    private static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;

        for (int i = 0;i<n;i++)
            totalSum += cardPoints[i];

        if(n == k) return totalSum;

        int windowSize = n - k;
        int windowSum = 0;

        for(int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minWindowSum = windowSum;

        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i];
            windowSum -= cardPoints[i - windowSize];
            minWindowSum = Math.min(minWindowSum, windowSum);
        }
        return totalSum - minWindowSum;
    }
}
