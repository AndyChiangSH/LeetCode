class Solution(object):
    def minimumPushes(self, word):
        """
        :type word: str
        :rtype: int
        """
        
        n = len(word)
        m = n // 8 + 1
        
        return m * (n - (4 * m) + 4)
        

# Accepted
# 500 / 500 testcases passed
