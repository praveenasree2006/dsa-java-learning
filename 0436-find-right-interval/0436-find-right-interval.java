class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        for(int i=0; i<intervals.length; i++)
            result[i] = search(intervals[i][1], intervals);
        return result;
    }
    
    private int search(int num, int[][] intervals){
        int idx = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0; i< intervals.length; i++){
            if(intervals[i][0] >= num && intervals[i][0] < min){
                idx = i;
                min = intervals[i][0];
            }
        }
        return idx;
    }
}