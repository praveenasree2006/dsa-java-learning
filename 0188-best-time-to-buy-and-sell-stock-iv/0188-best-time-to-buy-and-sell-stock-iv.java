class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length+1][2*k+1];
        for(int[] i:dp) Arrays.fill(i, -1);
        return f(0 , 0 , prices, prices.length , k, dp);
    }
    int f(int ind , int transno , int[] prices , int n , int k , int[][]dp){
        if(ind==n || transno==2*k) return 0;
        if(dp[ind][transno]!=-1) return dp[ind][transno];
         if(transno%2==0){
            dp[ind][transno]= Math.max(-prices[ind] + f(ind+1 , transno+1 ,prices , n, k, dp), 0+f(ind+1 ,transno , prices , n, k, dp));
         }else{
         dp[ind][transno]= Math.max(prices[ind] +f(ind+1 , transno+1 , prices , n ,k, dp) , 0+f(ind+1 , transno , prices, n, k, dp));
         }
         return dp[ind][transno];
    }
}
