class Solution(object):
    def sortArrayByParity(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        left=0
        right=len(nums)-1
        while left < right:
            if  nums[left]%2==0:
                left+=1
            elif nums[right]%2!=0:
                right-=1
            elif nums[left]%2!=0 and nums[right]%2==0:
                nums[left],nums[right]=nums[right],nums[left]
        return nums
        