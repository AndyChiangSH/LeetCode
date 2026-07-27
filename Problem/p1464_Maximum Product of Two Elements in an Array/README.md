# 1464. Maximum Product of Two Elements in an Array

## Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

不愧是 Easy，簡單到我不知道要講什麼...

不過還是勉強寫一下吧...

## Solution 1
<!-- Describe your approach to solving the problem. -->

最簡單的作法就是先排序數列，然後取第一大和第二大的數字相乘就結束了。

結果時間 100%，空間 97%...太簡單了吧！

### Code

```python []
class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        nums.sort(reverse=True)
        
        return (nums[0]-1) * (nums[1]-1)
```

### Complexity

- Time complexity: $$O(n log n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
- Space complexity: $$O(n)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Accepted 104 / 104 testcases passed  
> Runtime 0 ms Beats 100.00%  
> Memory 12.24 MB Beats 97.27%  

## Solution 2
<!-- Describe your approach to solving the problem. -->

更好的寫法是一個 for 迴圈，找出數列中第一大和第二大的數字，然後相乘，結束。

結果時間還是 100%，反而空間變成 72%？

### Code

```python []
class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        max1 = 0
        max2 = 0
        
        for x in nums:
            if x >= max1:
                max2 = max1
                max1 = x
            elif x >= max2:
                max2 = x
        
        return (max1-1) * (max2-1)
```

### Complexity

- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
- Space complexity: $$O(1)$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

### Result

> Accepted 104 / 104 testcases passed  
> Runtime 0 ms Beats 100.00%  
> Memory 12.32 MB Beats 72.23%  

---

<div align="center">
<sub>Date: 2026/07/27</sub>
<br>
<sub>Author: Andy Chiang</sub>
</div>