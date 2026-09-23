# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: int
        """
        self.ans = 0

        # Counts all valid paths starting from the current node.
        def dfs(node, cur):

            if not node:
                return

            cur += node.val

            if cur == targetSum:
                self.ans += 1

            dfs(node.left, cur)
            dfs(node.right, cur)

        if not root:
            return 0

        stack = [root]

        # Every node becomes a starting point.
        while stack:

            node = stack.pop()

            dfs(node, 0)

            if node.left:
                stack.append(node.left)

            if node.right:
                stack.append(node.right)

        return self.ans
        