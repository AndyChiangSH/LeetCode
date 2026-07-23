# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

一開始還看不懂 XOR 的意思，問了 ChatGPT 後才知道是二進位運算，如果位元一樣，那 XOR 就是 0，反之如果位元不一樣，那就是 1。

真值表如下：

| A | B | A XOR B |
| - | - | ------- |
| 0 | 0 | 0       |
| 0 | 1 | 1       |
| 1 | 0 | 1       |
| 1 | 1 | 0       |

舉例來說：

```
5 = 101
3 = 011
---------
XOR 110 = 6
```

因此 5 XOR 3 = 6

# Solutions
<!-- Describe your approach to solving the problem. -->

## Solution 1

最直覺的想法當然就是窮舉法啦！

直接用三個 FOR 迴圈，把 XOR 結果存入 set，最後再算 set 的長度就好了。

果不其然，時間複雜度太高了...

### Code

```python []
class Solution(object):
    def uniqueXorTriplets(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        xor_set = set()
        n = len(nums)
        
        for i in range(0, n):
            for j in range(i, n):
                for k in range(j, n):
                    xor = nums[i] ^ nums[j] ^ nums[k]
                    xor_set.add(xor)
                    
        return len(xor_set)
```

### Complexity
- Time complexity: $$Θ(n³)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(min(n³, 2^b))$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Time Limit Exceeded  
> 491 / 785 testcases passed

## Solution 2

既然窮舉法不行，那就來找規律吧。

我發現第一筆測資的 n = 2，答案為 2。

第二筆測資的 n = 3，答案為 4。

於是就天馬行空，想說會不會如果 n <= 2，答案就是 n。

如果 n > 2，答案則是 n+1？

結果果然沒有這麼簡單...

### Code
```python []
class Solution(object):
    def uniqueXorTriplets(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        n = len(nums)
        
        if n <= 2:
            return n
        else:
            return n+1
```

### Complexity
- Time complexity: $$O(1)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Wrong Answer  
> 39 / 785 testcases passed

## Solution 3

好吧，於是我又多觀察了幾筆測資，發現一個有趣的規則：

如果 n <= 2，答案就是 n。

如果 n > 2，答案則是 2 的 m 次方，m 是 n 的二進位元數。

仔細想想其實滿合理的，因為如果 n 是 m 位數，就表示 m 位數以下的所有數字都可能出現，最後再加上 0。

結果就通過了~

### Code
```python []
class Solution(object):
    def uniqueXorTriplets(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        n = len(nums)
        
        if n <= 2:
            return n
        else:
            return 2 ** n.bit_length()

```

### Complexity
- Time complexity: $$O(1)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Accepted  
> 785 / 785 testcases passed  
> Time taken: 1hr 1m 39s

![螢幕擷取畫面 2026-07-23 175544.png](https://assets.leetcode.com/users/images/7cd29604-50f0-47ed-9995-8ed541d31721_1784800558.2749107.png)
