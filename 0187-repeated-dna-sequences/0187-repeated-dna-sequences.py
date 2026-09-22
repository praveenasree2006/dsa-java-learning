class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        map = {}
        result = []

        for i in range(len(s) - 9):
            substring = s[i:i + 10]
            if substring in map:
                if map[substring] == 1:
                    result.append(substring)
                map[substring] += 1
            else:
                map[substring] = 1
        
         return result
        
