# p075_Sort Colors

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/sort-colors/)

給你一個數字陣列`nums[]`，元素為隨機分散的0、1和2，請將`nums[]`排序好 (且必須**in-place**)。

## 解題
雖然說排序最少要O(NlogN)，但這題我們已經確定只有0、1、2這三種數字，就有O(N)的解法了。

### 3-way partition
第一個想到這個，因為3-way partition會將小的放左邊，大的放右邊，相同的放中間，剛好對應到三個數字，只要掃過一遍就好。

> **⏳ 時間複雜度：O(N), N = nums.length**  
> **💾 空間複雜度：O(3), lt、gt、i**  

[GeeksforGeeks - 3-Way QuickSort](https://www.geeksforgeeks.org/3-way-quicksort-dutch-national-flag/)

### count & fill
類似count sort，不過因為只有三個數字，只需要計數0(zero)和1(one)的數量就好，接著就：
* `[0, zero-1]` 填入 0。
* `[zero, zero+one-1]` 填入 1。
* `[zero+one, N]` 填入 2。

> **⏳ 時間複雜度：O(2N), N = nums.length**  
> **💾 空間複雜度：O(2), zero、one**  

[C++ fill用法](https://www.cplusplus.com/reference/algorithm/fill/)

## 結果
### 3-way partition
也許是因為交換的成本比較大，結果反而比較慢，這只是我的猜測啦。

> 07/29/2021 08:38	Accepted	4 ms	8.3 MB	cpp  
> **⏳ 時間：48.20%**  
> **💾 空間：66.96%**  

### count & fill

> 07/29/2021 08:52	Accepted	0 ms	8.4 MB	cpp  
> **⏳ 時間：100.00%**  
> **💾 空間：22.36%**  

## 後記