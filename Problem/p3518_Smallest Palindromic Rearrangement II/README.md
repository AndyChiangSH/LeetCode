# [3518. Smallest Palindromic Rearrangement II](https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/description/?envType=daily-question&envId=2026-07-31)

###### tags: `LeetCode` `Hard`

## Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

今天的問題昨天已經寫完了，那就來補寫禮拜三的這題吧，終於寫到 Hard 的題目了！

這題是 [3517. Smallest Palindromic Rearrangement I](https://leetcode.com/problems/smallest-palindromic-rearrangement-i/?envType=daily-question&envId=2026-07-31) 的進階題，不是要求最小的字典排序回文，而是要求第 k 小的字典排序回文。

不可能直接窮舉出所有排列組合，所以要想想其他辦法...

## Solution 1
<!-- Describe your approach to solving the problem. -->

第一個想到的是高中數學的排列組合，通用公式為：

$$\frac{n!}{c_1!c_2!\cdots c_k!}$$

其中 `n` 是字串長度，`c₁、c₂...` 是每種字元出現的次數。

所以我們先固定第一個字元，然後計算有幾種排列組合 n。

如果 k > n，那就表示不在這個字母的範圍內，那就把 k -= n，然後改試下一個字母。

反之則表示在這個字母的範圍內，那就把這個字母加入字串 left_a，然後進到第二個字元。

依此類推，直到最後一位字元時，因為只剩一個，就把最後一個加入字串即可。

雖然說答案是正確的，但超時了，得想辦法優化才行...

### Code
```python []
import math

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
        
        for c in left_s:
            count[ord(c) - 97] += 1
        
        n = math.factorial(sum(count))
        for i in range(26):
            n //= math.factorial(count[i])
            
        if k > n:
            return ""
        
        left_a = ""
        
        while len(left_a) < len(left_s) - 1:
            for i in range(26):
                if count[i] == 0:
                    continue
                
                count[i] -= 1
                n = math.factorial(sum(count))
                for j in range(26):
                    n //= math.factorial(count[j])
                
                if k > n:
                    k -= n
                    count[i] += 1
                    continue
                else:
                    left_a += chr(i + 97)
                    break
        
        for i in range(26):
            if count[i] == 1:
                left_a += chr(i + 97)
                
        if len(s) % 2 == 0:
            return left_a + left_a[::-1]
        else:
            return left_a + mid_s + left_a[::-1]
```

### Complexity
- Time complexity: $$O(n^2)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Time Limit Exceeded 754 / 812 testcases passed  

## Solution 2
<!-- Describe your approach to solving the problem. -->

每次都要計算階層太麻煩了，乾脆直接建一個陣列，用動態規劃的方式計算階層，需要階層時直接查表即可。

雖然確實有快一點，但結果還是超時了...

### Code
```python []
import math

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
```

### Complexity
- Time complexity: $$O(n^2)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Time Limit Exceeded 764 / 812 testcases passed

## Solution 3
<!-- Describe your approach to solving the problem. -->

想說如果 count 等於 0 就直接跳過不算，看會不會快一點點？

結果只有快一點點，還是超時了...

### Code
```python []
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
```

### Complexity
- Time complexity: $$O(n^2)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Time Limit Exceeded 765 / 812 testcases passed

## Solution 4
<!-- Describe your approach to solving the problem. -->

實在是想不出來，只好請 ChatGPT 幫忙了...

你這個程式主要有兩個效能瓶頸：

1. 每嘗試一個字母，就重新遍歷 26 個字母並計算排列數。
2. 使用 `left_a += 字元`，字串不可變，反覆串接可能造成 (O(n^2))。

最重要的優化是：**排列數可以直接從目前的排列數推導出來，不需要重新計算階乘。**

假設目前剩下 `remaining` 個字元，共有：

$$ways=\frac{remaining!}{c_1!c_2!\cdots c_{26}!}$$

如果下一個位置選擇出現次數為 `count[i]` 的字母，那麼後續排列數是：

$$next_ways = ways \times \frac{count[i]}{remaining}$$

因此可以直接寫成：

```python
next_ways = ways * count[i] // remaining
```

果然這次就通過了，還真沒想過這種方法...

### Code
```python []
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

        for i in range(1, (mid + 1)):
            factorial[i] = factorial[i - 1] * i

        # 左半邊的不同排列總數
        n = factorial[mid]

        for i in range(26):
            if count[i] == 0:
                continue

            n //= factorial[count[i]]

        if k > n:
            return ""

        left_a = []

        while mid > 0:
            for i in range(26):
                if count[i] == 0:
                    continue

                # 假設目前位置放第 i 個字母
                # 不需要真的先 count[i] -= 1 再重新計算
                next_n = n * count[i] // mid

                if k > next_n:
                    # 跳過所有以這個字母開頭的排列
                    k -= next_n
                    continue
                else:
                    # 第 k 個排列位於這個字母的區間
                    left_a.append(chr(i + 97))
                    count[i] -= 1
                    mid -= 1
                    n = next_n
                    break

        left_a = "".join(left_a)

        if len(s) % 2 == 0:
            return left_a + left_a[::-1]
        else:
            return left_a + mid_s + left_a[::-1]
```

### Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Accepted 812 / 812 testcases passed  
> Runtime 724 ms | Beats 64.90%  
> Memory 29.40 MB | Beats 5.63%  

---

<div align="center">
<sub>Date: 2026/07/31</sub>
<br>
<sub>Author: Andy Chiang</sub>
</div>
