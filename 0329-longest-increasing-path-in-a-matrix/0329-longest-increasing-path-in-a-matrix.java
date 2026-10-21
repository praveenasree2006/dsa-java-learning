class Solution {
    public int getLongestPath(int i, int j, int[][] matrix, int[][] cache) {
        if (cache[i][j] != 0)
            return cache[i][j];


        int maxLength = 0;
        int val = matrix[i][j];


        if (i + 1 < matrix.length && matrix[i + 1][j] > val)
            maxLength = Math.max(maxLength, getLongestPath(i + 1, j, matrix, cache));


        if (i - 1 >= 0 && matrix[i - 1][j] > val)
            maxLength = Math.max(maxLength, getLongestPath(i - 1, j, matrix, cache));


        if (j + 1 < matrix[0].length && matrix[i][j + 1] > val)
            maxLength = Math.max(maxLength, getLongestPath(i, j + 1, matrix, cache));


        if (j - 1 >= 0 && matrix[i][j - 1] > val)
            maxLength = Math.max(maxLength, getLongestPath(i, j - 1, matrix, cache));


        cache[i][j] = 1 + maxLength;
        return cache[i][j];
    }


    public int longestIncreasingPath(int[][] matrix) {
        int longestPathLength = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] cache = new int[rows][cols];


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int l = getLongestPath(i, j, matrix, cache);
                longestPathLength = Math.max(l, longestPathLength);
            }
        }


        return longestPathLength;
    }
}