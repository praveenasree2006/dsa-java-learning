class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length == 0) return m * n;

        int minM = Integer.MAX_VALUE;
        int minN = Integer.MAX_VALUE;

        for(int[] op : ops) {
            minM = Math.min(minM, op[0]);
            minN = Math.min(minN, op[1]);
        }
        return minM * minN;
    }
}