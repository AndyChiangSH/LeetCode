# p4_Median Of Two Sorted Arrays

###### tags: `LeetCode`

## 題目
[原題目連結](https://leetcode.com/problems/median-of-two-sorted-arrays/)

給你兩個已經排序好的整數陣列(nums1、nums2)，請你求出**兩陣列合併之後的中位數**。

**重點: 時間複雜度必須在O(log(n+m))內!!!**

## 解題
第一個hard題目，原先看起來滿簡單的，看到複雜度限制後整個臉都綠了...

我原本以為LeetCode會有時間限制，結果我為了想演算法想了三天還是想不出來，後來真的不行了去看Discuss，才發現一堆人根本沒看清楚題目，什麼把兩個陣列合併起來在sort的拉基扣都有，還在那邊說他覺得這題好簡單，不應該是hard，看了就火大。

不過真的有大老寫出O(log(n+m))內的解法，原本為Python版本，我參考後改寫為Java版本。

大老就是猛，結果時間贏了99.87%，空間贏了86.03%。

[大老解法](https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn)))-solution-with-explanation)
[中文翻譯](https://zhuanlan.zhihu.com/p/70654378)

## 結果
> 03/27/2021 12:48	Accepted	2 ms	40.3 MB	java