class Solution(object):
    def tallestBillboard(self, rods):
        """
        :type rods: List[int]
        :rtype: int
        """
        dp = defaultdict(int)
        dp[0] = 0

        for rod in rods:
            temp = dp.copy()
            for key, value in dp.items():
                sum1 = key + rod
                sum2 = abs(key - rod)

                temp[sum1] = max(temp[sum1], value)
                temp[sum2] = max(temp[sum2], value + min(key, rod))
            dp = temp

        return dp.get(0, 0)
        