class Solution(object):
    def hasValidPath(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: bool
        """
        m = len(grid)
        n = len(grid[0])

        if (m + n - 1) % 2 != 0:
            return False

        if grid[0][0] == ')' or grid[m - 1][n - 1] == '(':
            return False

        dp = {}

        def dfs(i, j, balance):
            if i >= m or j >= n:
                return False

            if grid[i][j] == '(':
                balance += 1
            else:
                balance -= 1

            if balance < 0:
                return False

            if (i, j, balance) in dp:
                return dp[(i, j, balance)]

            if i == m - 1 and j == n - 1:
                return balance == 0

            down = dfs(i + 1, j, balance)
            right = dfs(i, j + 1, balance)

            dp[(i, j, balance)] = down or right

            return dp[(i, j, balance)]

        return dfs(0, 0, 0)
