# p098_Validate Binary Search Tree

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/validate-binary-search-tree/)

給定一個二元搜尋樹(Bineary Search Tree, BST)，請你求出是否為有效的BST。

二元搜尋樹左子樹的節點都要小於該節點，右子樹的節點都要大於該節點。

## 解題
不說廢話了，直接看下面的圖：

![](https://i.imgur.com/viLEmgJ.jpg)

上圖的黑字代表BST節點的數值，紅字代表有效區間。

可以觀察到，**左節點的區間是(父節點的區間最小值\~父節點數值)，右節點的區間是(父節點數值\~父節點的區間最大值)**。不在區間內就是無效的。

檢查是否有效並不困難，比較麻煩的點在於節點也可能是maxInt或minInt，造成判斷邊界可能會overflow，進一步造成判斷失誤。

最簡單的做法是**直接從int改成long**，避免overflow的問題，還有目前看到最好的方法是將**根節點的最大最小值改為null**，和maxInt、minInt有所區別。

> **⏳ 時間複雜度：O(n)**  
> **💾 空間複雜度：O(n)**  
> n = BST節點數

## 結果
> 08/11/2021 09:21	Accepted	0 ms	38.7 MB	java  
> **⏳ 時間：100.00%**  
> **💾 空間：52.36%**  

## 後記