# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def increasingBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: Optional[TreeNode]
        """
        self.ans = TreeNode(0)
        self.head = self.ans

        self.incOrder(root)

        return self.head.right

    def incOrder(self, root):
        if root is None:
            return

        self.incOrder(root.left)

        self.ans.right = root
        root.left = None
        self.ans = self.ans.right

        self.incOrder(root.right)
        