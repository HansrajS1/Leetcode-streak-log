class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int k = 1;
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (k <= n * n) {
            for (int i = left; i <= right; i++) {
                mat[top][i] = k++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                mat[i][right] = k++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                mat[bottom][i] = k++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                mat[i][left] = k++;
            }
            left++;
        }

        return mat;
    }
}
