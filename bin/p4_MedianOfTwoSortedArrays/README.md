# p4_Median Of Two Sorted Arrays

###### tags: `LeetCode`

## 題目
[原題目連結](https://leetcode.com/problems/median-of-two-sorted-arrays/)

給你兩個已經排序好的整數陣列(nums1、nums2)，請你求出**兩陣列合併之後的中位數**。

**重點: 時間複雜度必須在O(log(n+m))內!!!**

## 解題
第一個hard題目，原先看起來滿簡單的，看到複雜度限制後整個臉都綠了...

我原本以為LeetCode會有時間限制，結果我為了想演算法想了三天還是想不出來，後來真的不行了去看Discuss，才發現一堆人根本沒看清楚題目，什麼把兩個陣列合併起來在sort的拉基扣都有，還在那邊說他覺得這題好簡單，不應該是hard，相當傻眼。

不過真的有大老寫出O(log(n+m))內的解法，原本為Python版本，我參考後改寫為Java版本。

不過大老的解法不太好理解，大概講一下核心概念：

我們先把兩個陣列命名為A和B，並在i和j的位置一分為二，並將各自合併A和B的左半部以及右半部，且為了搜尋方便，我們讓A為長度較短的陣列。

```
      left_part          |        right_part
A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
```

如果要找到中位數，必須符合兩個條件

1. **left_part的數量等於right_part的數量**
2. **`B[j]` >= `A[i-1]` and `A[i]` >= `B[j-1]`**

第一個應該很好理解，第二個則是因為**如果右邊最小的都大於左邊最大的，代表右邊全部元素都大於左邊全部元素，那就是排序好的中間了**。

在第一個條件下，指定i就可得對應的j，且因為 `i+j=AB長度和的一半`，**`j = ((m+n+1)/2) - i`**。

如果符合第二個條件，就是找到了解答，但是如果...

1. **`B[j]` < `A[i-1]`**：A太大B太小，想讓A變小就要往左邊搜尋，因此imax = i-1。
2. **`A[i]` < `B[j-1]`**：A太小B太大，想讓A變大就要往右邊搜尋，因此imin = i+1。

> ⏳ 時間複雜度：O(log(min(n, m)))  
> 💾 空間複雜度：O(1)

[大老解法](https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn)))-solution-with-explanation) |
[中文翻譯](https://zhuanlan.zhihu.com/p/70654378)

## 結果
> 03/27/2021 12:48	Accepted	2 ms	40.3 MB	java  
> ⏳ 時間：99.88%  
> 💾 空間：89.01%