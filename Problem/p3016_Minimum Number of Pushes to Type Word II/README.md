# [3016. Minimum Number of Pushes to Type Word II](https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/description/)

###### tags: `LeetCode` `Medium`

## Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

今天只寫一題 Easy 感覺太少了，於是又再寫了一題，雖然這題高機率是明天的題目...

這題和 [3014. Minimum Number of Pushes to Type Word I](https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/description/?envType=daily-question&envId=2026-07-30) 差不多，只是這題的字母可以重複了。

## Solution 1
<!-- Describe your approach to solving the problem. -->

解法也很簡單，只要先算每個字母的出現頻率，然後將頻率從大排到小，將頻率前八大的字母排第一位，後八大的字母排第二位，其他依此類推。

### Code
```python []
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
```

### Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Accepted 877 / 877 testcases passed  
Runtime 209 ms | Beats 85.29%  
Memory 13.12 MB | Beats 5.88%  

## Solution 2
<!-- Describe your approach to solving the problem. -->

這題就沒辦法用數學解了，比較好的方法是用 heap 來排序頻率，理論上應該會快一點點，但實際上比 Solution 1 還慢...

### Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Code
```python []
from collections import Counter
import heapq


class Solution(object):
    def minimumPushes(self, word):
        """
        :type word: str
        :rtype: int
        """
        
        # Frequency map to store count of each letter
        frequency_map = Counter(word)

        # Priority queue to store frequencies in descending order
        frequency_queue = [-freq for freq in frequency_map.values()]
        heapq.heapify(frequency_queue)

        total_pushes = 0
        index = 0

        # Calculate total number of presses
        while frequency_queue:
            total_pushes += (1 + (index // 8)) * (
                -heapq.heappop(frequency_queue)
            )
            index += 1
            
        return total_pushes
```

### Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Accepted 877 / 877 testcases passed  
Runtime 436 ms | Beats 11.76%  
Memory 12.85 MB | Beats 38.24%  

---

<div align="center">
<sub>Date: 2026/07/30</sub>
<br>
<sub>Author: Andy Chiang</sub>
</div>