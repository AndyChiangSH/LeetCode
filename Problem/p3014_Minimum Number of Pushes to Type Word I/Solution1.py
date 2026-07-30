class Solution(object):
    def minimumPushes(self, word):
        """
        :type word: str
        :rtype: int
        """
        
        n = len(word)
        m = 0
        i = 1
        
        while True:
            if n > 8:
                m += 8 * i
                n -= 8
                i += 1
            else:
                m += n * i
                break
            
        return m
    

# Accepted
# 500 / 500 testcases passed
