class Solution(object):
    def smallestPalindrome(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        
        mid = len(s) // 2
        mid_s = s[mid]
        left_s = s[:mid]
        count = [0] * 26
        factorial = [1] * (mid + 1)
        
        for c in left_s:
            count[ord(c) - 97] += 1
            
        for i in range(1, len(factorial)):
            factorial[i] = factorial[i - 1] * i
        
        n = factorial[mid]
        for i in range(26):
            if count[i] == 0:
                continue
            
            n //= factorial[count[i]]
            
        if k > n:
            return ""
        
        left_a = ""
        
        while len(left_a) < len(left_s) - 1:
            for i in range(26):
                if count[i] == 0:
                    continue
                
                count[i] -= 1
                n = factorial[mid - 1]
                for j in range(26):
                    if count[j] == 0:
                        continue
                    
                    n //= factorial[count[j]]
                
                if k > n:
                    k -= n
                    count[i] += 1
                    continue
                else:
                    left_a += chr(i + 97)
                    mid -= 1
                    break
        
        for i in range(26):
            if count[i] == 1:
                left_a += chr(i + 97)
                
        if len(s) % 2 == 0:
            return left_a + left_a[::-1]
        else:
            return left_a + mid_s + left_a[::-1]


# Time Limit Exceeded
# 765 / 812 testcases passed
