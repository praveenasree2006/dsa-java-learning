class Solution(object):
    def findMaximizedCapital(self, k, w, profits, capital):
        """
        :type k: int
        :type w: int
        :type profits: List[int]
        :type capital: List[int]
        :rtype: int
        """
        n = len(profits)
        projects = [(capital[i], profits[i]) for i in range(n)]
        projects.sort()
        pq = []
        i = 0
        for _ in range(k):
            while i < n and projects[i][0] <= w:
                heapq.heappush(pq, -projects[i][1])
                i += 1
            if not pq:
                break
            w -= heapq.heappop(pq)
        return w
  