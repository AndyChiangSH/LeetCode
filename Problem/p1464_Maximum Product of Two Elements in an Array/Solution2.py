class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        max1 = 0
        max2 = 0
        
        for x in nums:
            if x >= max1:
                max2 = max1
                max1 = x
            elif x >= max2:
                max2 = x
        
        return (max1-1) * (max2-1)


# Accepted
# 104 / 104 testcases passed
