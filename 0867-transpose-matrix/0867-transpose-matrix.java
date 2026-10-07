class Solution {

    public int[][] transpose(int[][] matrix) {

        int n = matrix.length;//row
        int m = matrix[0].length;//column

        int[][] newmatrix = new int[m][n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                newmatrix[i][j] = matrix[j][i];
            }
        }
        return newmatrix;
    }
}