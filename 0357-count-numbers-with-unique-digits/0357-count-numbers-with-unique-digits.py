class Solution(object):
    def countNumbersWithUniqueDigits(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0: return 1
        total = 10
        prod = 9
        for i in range(2, n + 1):
            total += prod * (11 - i)
            prod *= 11 - i
        return total
        