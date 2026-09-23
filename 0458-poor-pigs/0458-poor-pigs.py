class Solution(object):
    def poorPigs(self, buckets, minutesToDie, minutesToTest):
        """
        :type buckets: int
        :type minutesToDie: int
        :type minutesToTest: int
        :rtype: int
        """
        max_time = minutesToTest / minutesToDie + 1
        
        req_pigs = 0
       
        while (max_time) ** req_pigs < buckets:
          
            req_pigs += 1
     
        return req_pigs
        