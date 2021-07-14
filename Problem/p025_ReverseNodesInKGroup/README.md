# p025_Reverse Nodes in k-Group

###### tags: `LeetCode` `Hard`

## 題目
[原題目連結](https://leetcode.com/problems/reverse-nodes-in-k-group/)

給你一條Linked List，請返回以每K個做為一組反轉後得到的結果。

**空間複雜度必須是O(1)。**

### example

![](https://i.imgur.com/NXPGjj6.png)

```
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
```

## 解題
這題在資結小考有出現過，看來助教也是在LeetCode上抓的?

總之，最大的問題在於 **如果Linked List長度不是K的倍數的話，最後多出的部分不能反轉**，因為我們不知道長度，所以如果用判斷Null為終止條件的話，最後的部分也會被反轉，所以我的作法很直接，就是先求出Linked List長度length，然後length/K就知道要做幾組了。

接著是反轉的部分，資結應該有講過，會是這樣：
```
ListNode pre = null, cur = newHead, nex = newHead.next;
for(int i = 0; i < k; i++) {
    cur.next = pre;
    pre = cur;
    cur = nex;
    nex = nex == null ? null : nex.next;
}
```

重點在遞迴，因為反轉的關係，**所以說反轉後的最後一個(也是原本的第一個)節點，要連接到下一組反轉後的第一個節點(也就是下一個原本的最後一個)節點**，我畫個圖示意一下：

一開始是這樣：

![](https://i.imgur.com/GGAi1be.jpg)

第一組先反轉完，第一組反轉後的最後一個節點是1。

![](https://i.imgur.com/7tpRkrV.jpg)

再來第二組反轉完，第二組反轉後的第一個節點是4

![](https://i.imgur.com/W3qqNzr.jpg)

然後從1連接到4。

![](https://i.imgur.com/gijbKVC.jpg)

3連到5。

![](https://i.imgur.com/YnJ2hu1.jpg)

整理一下，最後會是：

![](https://i.imgur.com/61qaZJ5.jpg)

完成!

我覺得我遞迴用的超漂亮，整個扣看起來乾淨又舒服~

### ⏳ 時間複雜度：O(2N)

### 💾 空間複雜度：O(1)

## 結果
### ⏳ 時間：100.00%

### 💾 空間：63.30%

![](https://i.imgur.com/cUCzsA1.png)
