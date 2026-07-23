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
            return 2 ** n.bit_length()


# Accepted
# 785 / 785 testcases passed
# Time taken: 1hr 1m 39s
