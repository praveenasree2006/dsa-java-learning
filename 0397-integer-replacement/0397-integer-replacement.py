class Solution(object):
    def integerReplacement(self, n):
        """
        :type n: int
        :rtype: int
        """
        cnt = 0
        while n != 1:
            if n % 2 == 0:
                n //= 2
            else:
                if n == 3 or n % 4 == 1:
                    n -= 1
                else:
                    n += 1
            cnt += 1
        return cnt
        