# p116_Populating Next Right Pointers in Each Node

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

給定一個完全二元樹，請你將同一層level的節點連接起來。next指標指向同一層中位於該節點右邊的節點，右邊沒有節點則為null。

**空間複雜度要求為O(1)。**

![](https://i.imgur.com/MYhNJWe.png)

## 解題
本來想用廣度，但空間限制讓我不能用Queue，因此作罷。

接著就靈光一閃，Queue本來的作用不就是將同一層的節點存在一起嗎? 既然這樣，**那把上一層當作linked list一個個節點尋訪**，不就跟Queue同等的效果嗎? 有了這個想法後立刻開始實作，結果比想像中來的單純。

* 首先，將每一層最左邊的點當作head，是由next所形成的linked list的開頭。
* 走訪linked list上的每個節點，把每個節點的左子和右子連接。
* 用另外一個指標指向最後一個點，把最後一個點跟新的左子連接。
* 當head的next等於null時(最後一層)，就結束迴圈。

我這個做法用到3個指標，我有看到有人只使用2個指標，但自己實測結果反而發現消耗更多記憶體，最後還是丟3個指標的版本。

> **⏳ 時間複雜度：O(n)**  
> **💾 空間複雜度：O(3)**  

## 結果
### XX解

> 08/20/2021 10:23	Accepted	0 ms	38.7 MB	java  
> **⏳ 時間：100.00%**  
> **💾 空間：98.20%**  

## 後記
因為測資不好產生啦，所以我寫完後完全沒有Debug就丟上去，結果就AC了! 真讓我意外XDDD

也因為覺得寫得不錯，所以我發了一篇[Discuss](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/1414519/Java-solution-with-3-pointer)，用來記錄一下。