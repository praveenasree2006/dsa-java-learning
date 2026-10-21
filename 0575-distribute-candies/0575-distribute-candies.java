class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int n = candyType.length;
        for(int i=0;i<n;i++)
        set.add(candyType[i]);

        int m = set.size();
        return Math.min(m,n/2);
        
    }
}