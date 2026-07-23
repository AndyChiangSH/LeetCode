class Solution(object):
    def uniqueXorTriplets(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        xor_set = set()
        n = len(nums)
        for i in range(0, n):
            for j in range(i, n):
                for k in range(j, n):
                    xor = nums[i] ^ nums[j] ^ nums[k]
                    xor_set.add(xor)
                    
        return len(xor_set)

# Time Limit Exceeded
# 491 / 785 testcases passed
