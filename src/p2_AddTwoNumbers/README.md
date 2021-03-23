# p2_AddTwoNumbers

###### tags: `LeetCode`

## 題目
[原題目連結](https://leetcode.com/problems/add-two-numbers/)

題目會給你兩個Linked list(l1、l2)，從個位數往後排，請你求出兩個Linked list相加之後的答案，必須以Linked list形式回傳。

![](https://i.imgur.com/DLWBci3.png)

## 解題
有點像資料結構的多項式題目，用while迴圈將l1和l2的值相加，加完後往前進，如果相加大於10要考慮進位的問題，迴圈一直到l1和l2都結束，然後要特別注意最後一個位元也有可能進位。

也可以使用遞迴，但LeetCode有限制函式參數，會沒辦法傳遞進位(carry)，因此作罷。

## 結果
> 03/23/2021 22:27	Accepted	2 ms	39.6 MB	java