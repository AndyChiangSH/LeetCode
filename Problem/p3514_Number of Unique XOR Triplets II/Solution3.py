class Solution(object):
    def uniqueXorTriplets(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        nums.sort()
        xor_set = set(nums)
        n = len(nums)
        m = nums[n-1]
        
        for j in range(0, n-1):
            for k in range(j+1, n-1):
                xor = m ^ nums[j] ^ nums[k]
                xor_set.add(xor)
        
        return len(xor_set)


Wrong Answer
365 / 825 testcases passed
