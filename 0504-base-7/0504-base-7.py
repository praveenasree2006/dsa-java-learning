class Solution(object):
    def convertToBase7(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return "0"
        negative = num < 0
        num = abs(num)
        res = []
        while num > 0:
            res.append(str(num % 7))
            num //= 7
        if negative:
            res.append('-')
        return ''.join(res[::-1])
        