class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children if children is not None else []

class Solution(object):
    def maxDepth(self, root):
        if not root:
            return 0

        max_depth = 0
        stack = [(root, 1)]

        while stack:
            node, depth = stack.pop()
            max_depth = max(max_depth, depth)
            for child in node.children:
                stack.append((child, depth + 1))

        return max_depth