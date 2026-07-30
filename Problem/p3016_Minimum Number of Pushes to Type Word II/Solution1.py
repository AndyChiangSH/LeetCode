class Solution(object):
    def minimumPushes(self, word):
        """
        :type word: str
        :rtype: int
        """
        
        m = 0
        count = [0] * 26
        
        for c in word:
            count[ord(c) - 97] += 1
            
        count.sort(reverse=True)
        
        for i, c in enumerate(count):
            if c == 0:
                break
            
            m += (i // 8 + 1) * c
            
        return m


# Accepted
# 877 / 877 testcases passed
