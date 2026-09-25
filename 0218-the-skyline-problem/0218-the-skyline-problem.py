import heapq

class Solution:
    def getSkyline(self, buildings: list[list[int]]) -> list[list[int]]:
        events = []
        for L, R, H in buildings:
            events.append((L, -H, R))
            events.append((R, H, 0))
        
        events.sort()
        
        result = []
        # (max_height, end_x)
        pq = [(0, float('inf'))]
        prev_max_height = 0
        
        for x, neg_h, R in events:
            # Remove buildings that have ended before or at current x
            while pq[0][1] <= x:
                heapq.heappop(pq)
                
            if neg_h < 0:
                # Start of a building
                heapq.heappush(pq, (neg_h, R))
                
            curr_max_height = -pq[0][0]
            
            if curr_max_height != prev_max_height:
                result.append([x, curr_max_height])
                prev_max_height = curr_max_height
                
        return result
