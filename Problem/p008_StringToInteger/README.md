# p8_String to Integer (atoi)

###### tags: `LeetCode`

## 題目
[原題目連結](https://leetcode.com/problems/string-to-integer-atoi/)

給你一個字串，請你將字串中的數字轉為整數型態，並回傳改整數(n)。

* -2^32^ <= n <= 2^32^-1，如果超過則返回最大值或最小值
* 數字前的空白需省略
* 數字會以一個非數字的符號結束
* 數字前如果是 "+" 符號則數字為正，如果是 "-" 符號則數字為負，如果沒有則預設為正

## 解題
這題沒什麼演算法好想的，就只是許多的條件判斷，我的解題步驟如下:
1. 先刪除字串中多餘的空白
2. 看第一位是 "+"、"-" 還是數字
3. 將字串轉為數字
4. 判斷有無overflow

判斷有無overflow我是依照第七題的做法，如果現在數字大於 INT_MAX(2^32^-1)/10 的話，則overflow。如果現在數字等於 INT_MAX(2^32^-1)/10 的話，則判斷個位數有無超過7(負數的話是8)，有則overflow。

## 結果
> 04/17/2021 13:47	Accepted	1 ms	38.9 MB	java
> 時間100% 空間67.43%

測試別人教的 str.trim()，結果還是我寫的必較快
> 04/17/2021 13:57	Accepted	2 ms	38.8 MB	java
> 時間54.31% 空間67.43%