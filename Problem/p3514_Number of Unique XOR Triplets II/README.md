# [3514. Number of Unique XOR Triplets II](https://leetcode.com/problems/number-of-unique-xor-triplets-ii/description/)

###### tags: `LeetCode` `Medium`

## Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

第一眼還以為跟 [昨天那題](https://leetcode.com/problems/number-of-unique-xor-triplets-i/description/) 一樣，結果仔細一看還是有點不同，這題的 nums 不是一個 Permutation (1~n 的數字都有)，而是隨機的數列。

看來是沒辦法像昨天一樣偷吃步了...

## Solution 1
<!-- Describe your approach to solving the problem. -->

第一個想法當然還是窮舉法啦！

果不其然超時了...

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
- Time complexity: $$O(n³)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

## Result

> Time Limit Exceeded
560 / 825 testcases passed

## Solution 2
<!-- Describe your approach to solving the problem. -->

既然超時了，那如果先計算 i XOR j，然後再計算 x XOR k 呢...？

沒差太多，果然還是超時...

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
                ij_xor = nums[i] ^ nums[j]
                for k in range(j, n):
                    xor = ij_xor ^ nums[k]
                    xor_set.add(xor)
                    
        return len(xor_set)
```

### Complexity
- Time complexity: $$O(n³)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Time Limit Exceeded
563 / 825 testcases passed

## Solution 3
<!-- Describe your approach to solving the problem. -->

看完提示後突發奇想，如果是用最大值和其他組合計算 XOR 呢...？

結果直接答案錯誤...

### Code
```python []
class Solution(object):
    def uniqueXorTriplets(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        nums.sort()
        xor_set = set(nums)
        n = len(nums)
        m = nums[n-1]
        
        for j in range(0, n-1):
            for k in range(j+1, n-1):
                xor = m ^ nums[j] ^ nums[k]
                xor_set.add(xor)
        
        return len(xor_set)
```

### Complexity
- Time complexity: $$O(n²)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Wrong Answer
365 / 825 testcases passed

## Solution 4
<!-- Describe your approach to solving the problem. -->

最後實在想不出來，只好偷看解答了...

結果是分成兩步驟，先算 i XOR j = two，再算 two XOR k = three。

原來這麼簡單，是我把這題想太難了...

### Code
```python []
class Solution(object):
    def uniqueXorTriplets(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        one = set(nums)
        two = set()
        three = set()
        
        for i in one:
            for j in one:
                two.add(i ^ j)
                
        for i in one:
            for j in two:
                three.add(i ^ j)
                
        return len(three)
```

### Complexity
- Time complexity: $$O(n²)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Accepted
825 / 825 testcases passed
Time taken: 2hrs 16m 0s

## Solution 5
<!-- Describe your approach to solving the problem. -->

不過因為時間還是有點慢，所以又試了第一種寫法。

結果比第二種還快...？

### Code
```python []
class Solution(object):
    def uniqueXorTriplets(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        m = max(nums)
        u = 1
        while u <= m:
            u <<= 1
            
        s = [False] * u
        n = len(nums)
        
        for i in range(n):
            for j in range(i, n):
                s[nums[i] ^ nums[j]] = True
                
        t = [False] * u
        
        for x in range(u):
            if not s[x]:
                continue
            for v in nums:
                t[x ^ v] = True
                
        return sum(1 for b in t if b)
```

### Complexity
- Time complexity: $$O(n²)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Accepted
825 / 825 testcases passed

![螢幕擷取畫面 2026-07-24 180744.png](https://assets.leetcode.com/users/images/5534cb15-7164-4499-b8bc-a27c76a49428_1784887675.3323295.png)

---

<div align="center">
<sub>Date: 2026/07/24</sub>
<br>
<sub>Author: Andy Chiang</sub>
</div>