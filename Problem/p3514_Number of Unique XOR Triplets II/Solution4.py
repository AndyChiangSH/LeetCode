class Solution(object):
    def uniqueXorTriplets(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        one = set(nums)
        two = set()
        three = set()
        
        for i in one:
            for j in one:
                two.add(i ^ j)
                
        for i in one:
            for j in two:
                three.add(i ^ j)
                
        return len(three)
    

# Accepted
# 825 / 825 testcases passed
# Time taken: 2hrs 16m 0s
