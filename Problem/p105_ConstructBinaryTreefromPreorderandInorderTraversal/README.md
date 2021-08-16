# p105_Construct Binary Tree from Preorder and Inorder Traversal

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

給你兩個一維陣列，分別表示前序(preorder)表示和中序(inorder)表示的順序，請回傳原本二元樹的樣子。

## 解題
來講這題怎麼做吧，首先preorder和inorder有各自的作用。
* preorder：提供遞迴順序的資訊。
* inorder：提供節點位置的資訊(左節點還是右節點?)

因此我主要是依照preorder的順序，並利用值當成key，搜尋在inorder中的位置，搜尋部分可以用**HashMap**或**直接for迴圈**，就自己斟酌選一種來用吧。
* **HashMap**：省時間、耗空間
* **for迴圈**：省空間、耗時間

接著是用Divide and Conquer的技巧，在inorder的順序中，以index為中點，分成左邊(min\~i-1)和右邊(i+1\~max)並往下層遞迴，檢查下個點是否在範圍內，如果是就回傳節點本身，不是則回傳null，另外當pre_index大於等於preorder長度時也要回傳null，我試過不加會跑出ArrayOutOfRange錯誤訊息。

最後呼叫開始遞迴就好了，初始範圍從0~len-1。

> **HashMap**  
> **⏳ 時間複雜度：O(n)**  
> **💾 空間複雜度：O(2n)**  

> **for迴圈**  
> **⏳ 時間複雜度：O(n)**  
> **💾 空間複雜度：O(n)**  

## 結果
### HashMap

> 08/16/2021 10:34	Accepted	1 ms	39.3 MB	java  
> **⏳ 時間：98.78%**  
> **💾 空間：30.82%**  

### for迴圈

> 08/16/2021 11:02	Accepted	3 ms	38.3 MB	java  
> **⏳ 時間：50.90%**  
> **💾 空間：99.71%**  

## 後記
這題真的很酷ㄟ! 第一次看到這種類型的題目，不然我以前真的沒想過用程式做這件事。