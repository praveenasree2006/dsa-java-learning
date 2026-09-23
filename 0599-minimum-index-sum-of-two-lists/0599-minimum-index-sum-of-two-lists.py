class Solution(object):
    def findRestaurant(self, list1, list2):
        """
        :type list1: List[str]
        :type list2: List[str]
        :rtype: List[str]
        """
        ans = []
        realans = []
        istrue = True
        minnum = float('inf')
        for i in range(0,len(list1)):
            if(list1[i] in list2):
                j = list2.index(list1[i])
                minnum = min(minnum, i + j)
                if(i + j <= minnum):
                    ans.append(list1[i])
        
        for k in range(len(ans)):
            word = ans[k]
            i = list1.index(word)
            j = list2.index(word)
            if(i + j <= minnum):
                realans.append(word)
        return realans