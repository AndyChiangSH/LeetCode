# p029_Divide Two Integers

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/divide-two-integers/)

給你兩個數字N和M，請求出N/M，結果無條件捨去小數位。但不能使用 `*`、`/`、`%`。

## 解題
既然不能用乘除，就改成用加減吧，有點像逼近法慢慢趨近最接近M的最大N的倍數，比較麻煩的點反而在於overflow，要處理滿多例外情況的。

## 結果
> 06/30/2021 23:58	Accepted	1 ms	36.2 MB	java  
> 時間：100.00% / 空間：51.20%