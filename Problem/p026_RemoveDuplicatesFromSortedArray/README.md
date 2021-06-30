# p026_Remove Duplicates from Sorted Array

###### tags: `LeetCode` `Easy`

## 題目
[原題目連結](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

給你一個排序好的陣列，請在不使用額外空間的情況下，回傳消除重複數值的陣列。

## 解題
解法很簡單，只要一個紀錄不重複的數值到哪裡(i)，另一個往陣列前檢查，每檢查到一個不重複的就放到i的位置，原本的值被覆蓋也沒差，因為也不會用到，最後回傳i+1就好。

時間複雜度：O(N)，因為沒有額外空間，所以空間複雜度為O(1)。

## 結果
> 06/30/2021 22:49	Accepted	0 ms	40.2 MB	java  
> 時間：100.0% / 時間：97.07%