# [3517. Smallest Palindromic Rearrangement I](https://leetcode.com/problems/smallest-palindromic-rearrangement-i/description/?envType=daily-question&envId=2026-07-28)

###### tags: `LeetCode` `Medium`

## Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

雖然難度是 Medium，但我覺得只有 Easy...

給你一個回文字串 s，請重新排列並求出 Lexicographically Smallest Palindromic

Lexicographically Smallest Palindromic 看起來很難，但其實就是字典排序最小的回文，字典排序就是照著 abc... 從小排到大。

## Solution 1
<!-- Describe your approach to solving the problem. -->

因為是回文，左右邊是對稱的，所以從中間切一半就好。

然後將一半的回文根據字典排序從小排到大，剛好 Python 的 `sorted()` 就可以直接做到。

不過要考慮到回文長度是奇數時，正中間的字元不能移動。

### Code
```python []
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
```

### Complexity
- Time complexity: $$O(n log n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Accepted 930 / 930 testcases passed  
> Runtime 357 ms Beats 73.53%  
> Memory 14.23 MB Beats 32.35%

## Solution 2
<!-- Describe your approach to solving the problem. -->

不過 Sort 畢竟還是要 $$O(n log n)$$，有沒有其他更快的方法呢？

有的！那就是算回文中每個字元有幾個，然後在從 a 到 z 每個字元乘上數量，最後合併起來就是最小字典排序回文了。

因為只需要掃過字串一遍，所以時間複雜度是 $$O(n)$$~

### Code
```python []
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
```

### Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Accepted 930 / 930 testcases passed  
> Runtime 204 ms Beats 100.00%  
> Memory 13.75 MB Beats 52.94%  

---

<div align="center">
<sub>Date: 2026/07/28</sub>
<br>
<sub>Author: Andy Chiang</sub>
</div>