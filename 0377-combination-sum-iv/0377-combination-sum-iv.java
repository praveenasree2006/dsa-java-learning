public class Solution {
    public int combinationSum4(int[] nums, int target) {
        // dp[i] represents the number of combinations to make sum 'i'
        long[] dp = new long[target + 1];
        
        // There is one way to make sum 0, which is by not selecting any number.
        dp[0] = 1;
        
        for (int currentSum = 1; currentSum <= target; currentSum++) {
            for (int numIndex = 0; numIndex < nums.length; numIndex++) {
                int currentNum = nums[numIndex];
                if (currentSum - currentNum >= 0) {

                    dp[currentSum] += dp[currentSum - currentNum];
                }
            }
        }
        

        return (int)dp[target];
    }
}