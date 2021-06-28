# p15_3Sum

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/3sum/)

給定一個整數的一維陣列，請你求出所有三個數字和為0的組合。注意! 重複的組合不計入答案中。

## 解題
我在演算法作業02就已經講過3Sum的做法了，想知道詳細作法請來[這裡](https://hackmd.io/ciP3-k6NSRiUaPT-SDEbTw)看。

**講幾個我寫LeetCode遇到的問題：**

* 題目要我回傳 `List<List<Integer>>` 型態，但我根本不知道List是什麼阿? 我覺得LeetCode在這題的講解沒有很清楚，導致我一開始根本不知所措。後來發現好像可以是任意的List，但程式碼就無法在Eclipse上執行了。
* 跟演算法作業不太一樣，要排除重複的組合，我自己用while跳過重複值，也有看到有人用HashSet，不過就超級慢~
* 因為有重複值，所以不能使用BinarySearch找0的位置，我就改用直接一個for迴圈掃過去拉。

## 結果
> 06/10/2021 00:58	Accepted	15 ms	42.5 MB	java  
> 時間：99.79% / 空間：89.27%