# p102_Binary Tree Level Order Traversal

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/binary-tree-level-order-traversal/)

給你一棵二元樹，請依照節點深度分類。

## 解題
看到樹不外乎就是DFS或BFS了吧。

### DFS
因為當初覽的實作Queue，就想說先試試DFS吧!

作法沒什麼特別的，就只是用遞迴，每次往下傳就將深度+1，並將節點放入對應深度的ArrayList中，比較要注意是第一個節點要建立新的ArrayList。

### BFS
現在才知道原來Java的Queue是LinkedList實作的啊。

總之，大家都知道廣度搜尋一輪是跑同一個深度的節點，而Queue的目的就在記錄同樣下一層深度的節點，其他的沒什麼特別的就不說了。

兩者相較之下，BFS略勝一籌，我猜是因為一輪做完同深度的節點，比較單純。

> **⏳ 時間複雜度：O(N)**  
> **💾 空間複雜度：O(N)**  

## 結果
### XX解

> 8/13/2021 09:07	Accepted	0 ms	39.3 MB	java  
> **⏳ 時間：100.00%**  
> **💾 空間：37.06%**  

## 後記
後面連續好幾題都是和Tree有關的題目，就當成再複習吧!

比起泛型 `List<List<Integer>> ans = new ArrayList<>();` ， `List<List<Integer>> ans = new ArrayList<List<Integer>>();` 相對來講比較快。