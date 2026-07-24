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
                ij_xor = nums[i] ^ nums[j]
                for k in range(j, n):
                    xor = ij_xor ^ nums[k]
                    xor_set.add(xor)
                    
        return len(xor_set)


# Time Limit Exceeded
# 563 / 825 testcases passed
