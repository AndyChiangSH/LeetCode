class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        nums.sort(reverse=True)
        
        return (nums[0]-1) * (nums[1]-1)


# Accepted
# 104 / 104 testcases passed
# Time taken: 10m 58s
