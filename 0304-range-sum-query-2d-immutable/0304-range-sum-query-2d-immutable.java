class NumMatrix {

    // Original matrix (optional, not actually needed after preprocessing)
    int[][] matrix;

    // Prefix Sum Matrix
    // pmSum[i][j] = Sum of all elements from (0,0) to (i,j)
    int[][] pmSum;

    // Builds the Prefix Sum Matrix
    public void getMatrixPrefixSum(int[][] matrix) {

        // First cell
        pmSum[0][0] = matrix[0][0];

        // Fill first row
        // Since there is nothing above, keep adding from left
        for (int col = 1; col < matrix[0].length; col++) {
            pmSum[0][col] = pmSum[0][col - 1] + matrix[0][col];
        }

        // Fill first column
        // Since there is nothing on the left, keep adding from top
        for (int row = 1; row < matrix.length; row++) {
            pmSum[row][0] = pmSum[row - 1][0] + matrix[row][0];
        }

        // Fill the remaining cells
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {

                /*
                 * Formula:
                 *
                 * Top Prefix
                 * + Left Prefix
                 * - Top Left Prefix (because it gets counted twice)
                 * + Current Cell
                 */

                pmSum[i][j] =
                        pmSum[i - 1][j]
                      + pmSum[i][j - 1]
                      - pmSum[i - 1][j - 1]
                      + matrix[i][j];
            }
        }
    }

    // Returns prefix sum safely
    // If row or column becomes negative,
    // return 0 (helps while calculating boundaries)
    public int getValue(int row, int col) {

        if (row < 0 || col < 0)
            return 0;

        return pmSum[row][col];
    }

    public NumMatrix(int[][] matrix) {

        this.matrix = matrix;

        pmSum = new int[matrix.length][matrix[0].length];

        getMatrixPrefixSum(matrix);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        /*
         * total = Entire rectangle till Bottom Right
         */
        int total = getValue(row2, col2);

        /*
         * Remove upper row
         */
        int top = getValue(row1 - 1, col2);

        /*
         * Remove left col
         */
        int left = getValue(row2, col1 - 1);

        /*
         * Add overlap back
         * (because it was removed twice)
         */
        int overlap = getValue(row1 - 1, col1 - 1);

        return total - top - left + overlap;
    }
}