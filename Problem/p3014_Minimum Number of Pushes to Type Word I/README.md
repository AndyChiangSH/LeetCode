# [3014. Minimum Number of Pushes to Type Word I](https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/description/?envType=daily-question&envId=2026-07-30)

###### tags: `LeetCode` `Easy`

## Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

又是 Easy，雖然題目描述很複雜，但其實超簡單...

因為只有八個按鍵，而且字母又不會重複，所以只要把前八個字母放在第一位，後八個字母放在第二位，其他依此類推。

## Solution 1
<!-- Describe your approach to solving the problem. -->

用一個 while 迴圈就可以解決了，每次就檢查長度有沒有大於 8，如果有那就加上去，如果沒有那就結束迴圈。

時間雖然 100%，但空間還是不太滿意...

### Code
```python []
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
```

### Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Accepted 500 / 500 testcases passed  
Runtime 0 ms Beats 100.00%  
Memory 12.44 MB Beats 32.69%  

## Solution 2
<!-- Describe your approach to solving the problem. -->

更簡單暴力的方法，稍微數學推導了一下，發現具有以下規律：

$$A = m * (n - (4 * m) + 4)$$

其中 n 為字串長度，m 則是 n // 8 + 1。

時間和空間都 100%，完美收工~

### Code
```python []
class Solution(object):
    def minimumPushes(self, word):
        """
        :type word: str
        :rtype: int
        """
        
        n = len(word)
        m = n // 8 + 1
        
        return m * (n - (4 * m) + 4)
```

### Complexity
- Time complexity: $$O(1)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Accepted 500 / 500 testcases passed  
Runtime 0 ms Beats 100.00%  
Memory 12.15 MB Beats 100.00%  

---

<div align="center">
<sub>Date: 2026/07/30</sub>
<br>
<sub>Author: Andy Chiang</sub>
</div>