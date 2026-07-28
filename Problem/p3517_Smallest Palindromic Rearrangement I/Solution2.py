class Solution(object):
    def smallestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        
        n = len(s)
        mid = n // 2
        mid_c = s[mid]
        half_s = s[:mid]
        count = [0] * 26
        half_lsp = ""
        
        for c in half_s:
            count[ord(c) - 97] += 1
            
        for i, c in enumerate(count):
            half_lsp += chr(i + 97) * c
        
        if n % 2 == 0:
            return half_lsp + half_lsp[::-1]
        else:
            return half_lsp + mid_c + half_lsp[::-1]


# Accepted
# 930 / 930 testcases passed
