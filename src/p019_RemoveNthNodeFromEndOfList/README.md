# p19_Remove Nth Node From End of List

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

給定一個鏈結串列(Linked List)，請你移除**倒數第 N 個**節點。

### example: n = 2

![](https://i.imgur.com/y5lIoVI.png)

## 解題
最差的解法當然是先掃一遍，知道串列長度是多少後，再找倒數第N個的節點，複雜度明顯是**O(2N)**。

好的解法是，宣告兩個指標lead和follow，lead在串列上一直跳到下一個節點，當到達第N個節點時，follow從head開始跟隨在後，每次兩個指標都跳到下一個節點，直到lead到串列尾端。

為什麼會是對的? 你想，lead和follow之間固定間隔了N個節點，那麼當lead到尾端時，follow的位置是不是正是倒數第N個了? 另外，還要考慮到移除head的特殊狀況。

這觀念不難，回去畫個圖好好想就可以。複雜度是**O(N)**。

## 結果
> 06/12/2021 00:14	Accepted	0 ms	36.5 MB	java  
> 時間：100% / 空間：98.72%

舒服~~
![](https://i.imgur.com/fdQ8xAy.png)
