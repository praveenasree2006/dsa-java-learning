class Solution(object):
    def maxDepthAfterSplit(self, seq):
        """
        :type seq: str
        :rtype: List[int]
        """
        res = []

        for i in range(len(seq)):
            res.append((i ^ ord(seq[i])) & 1)

        return res
        