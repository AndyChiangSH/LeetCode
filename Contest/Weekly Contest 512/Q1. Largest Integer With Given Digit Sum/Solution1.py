class Solution(object):
    def largestInteger(self, n, s):
        """
        :type n: int
        :type s: int
        :rtype: int
        """
        
        if s == 0:
            return 0
        
        if s > (9 * n):
            return -1
        
        for i in range((10 ** n -1), 0, -1):
            digit_sum = sum(int(digit) for digit in str(i))
            if digit_sum == s:
                return i
            
        return -1
