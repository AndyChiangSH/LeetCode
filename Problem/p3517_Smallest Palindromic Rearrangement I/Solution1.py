class Solution(object):
    def smallestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        
        n = len(s)
        
        if n % 2 == 0:
            mid = n // 2
            half_s = s[:mid]
            half_lsp = "".join(sorted(half_s))
            
            return half_lsp + half_lsp[::-1]
        else:
            mid = n // 2
            c = s[mid]
            half_s = s[:mid]
            half_lsp = "".join(sorted(half_s))
            
            return half_lsp + c + half_lsp[::-1]


# Accepted
# 930 / 930 testcases passed
