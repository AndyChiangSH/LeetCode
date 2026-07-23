class Solution(object):
    def uniqueXorTriplets(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        n = len(nums)
        
        if n <= 2:
            return n
        else:
            return n+1

# Wrong Answer
# 39 / 785 testcases passed
