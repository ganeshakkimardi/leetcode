package practise.leetCode;

import java.util.Arrays;

public class SpiralTraversal_TwoD_To_OneD_Matrix {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] result = spiralTraversal(matrix);
        System.out.println(Arrays.toString(result));
    }

    static int[] spiralTraversal(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] result = new int[rows * cols];
        int index = 0;

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        while (top <= bottom && left <= right) {

            // Left to Right
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            top++;

            // Top to Bottom
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            right--;

            // Right to Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[index++] = matrix[bottom][i];
                }
                bottom--;
            }

            // Bottom to Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[index++] = matrix[i][left];
                }
                left++;
            }
        }
        return result;
    }
}