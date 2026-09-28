class Solution(object):
    def maxDepth(self, s):
        """
        :type s: str
        :rtype: int
        """
        depth = []
        max_depth = 0

        for c in s:
            if c == '(':
                depth.append(c)
                max_depth = max(max_depth, len(depth))

            elif c == ')':
                depth.pop()

        return max_depth
        