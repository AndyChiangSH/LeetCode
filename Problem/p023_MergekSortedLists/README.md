# p23_Merge k Sorted Lists

###### tags: `LeetCode` `Hard`

## 題目
[原題目連結](https://leetcode.com/problems/merge-k-sorted-lists/)

給你K條已經排序好的LinkedList，請求出合併K條並且排序好的LinkedList。

<details><summary><b>測資範圍</b></summary>

* `k == lists.length`
* `0 <= k <= 10^4`
* `0 <= lists[i].length <= 500`
* `-10^4 <= lists[i][j] <= 10^4`
* `lists[i]` is sorted in ascending order.
* The sum of `lists[i].length` won't exceed 10^4.

</details>

## 解題
### 直接暴力解
這題看起來就是Merge Sort的形狀，那就跟Merge Sort做一樣的事情就好啦! 唯一的差別只在於有K條LinkedList，所以暴力解就是每次就在K條LinkedList的tail中求最小值，然後將最小值加入融合後的LinkedList就行了。

全部有N個數值(K條LinkedList總和)，每次從K條LinkedList中求最小值，所以最後的複雜度是：**O(N\*K)**

每次找最小值時，就有K-1個點重複比較過的，所以顯然這不是好方法。現在的情形是每次從長度為K的容器中取出最小值，並加入新的值進入容器中，這時就可以用演算法教的Heap了!

### Min Heap
因為每次取最小值，所以使用到Min Heap，在Java中的PriorityQueue就是同樣效用，只要先將K條LinkedList的tail加入PriorityQueue，每次取的一定是最小值，就這樣反覆進行，因為null不加入PriorityQueue，因此PriorityQueue如果空了即結束迴圈。

操作Min Heap的複雜度是O(logK)，一共執行N遍，所以總複雜度是：**O(N\*logK)**。

### mergeTwoList
更有趣的來了，暴力解為什麼慢? 是因為每次都要從K個數字中取最小。以前merge two linkedlist為什麼快? 是因為只需要兩個數字比較就好。 既然如此，那只要把K條linkedlist分成兩兩一對做merge就好啦!

這其實也是merge sort的最初定義：**兩個排序好的陣列merge後的陣列也是排序好的**。

只差在merge sort的最小單位是一個數值，而這題是一條linkedlist而已，其他partition、merge就像merge sort一樣。

![](https://i.imgur.com/9rFKjW2.jpg)

順帶一提，看到有人merge two list使用遞迴，雖然比較慢，但滿有趣的還是貼在[這邊](https://leetcode.com/problems/merge-k-sorted-lists/discuss/10522/My-simple-java-Solution-use-recursion)。

### 空間優化方法
我們不要產生一條新的LinkedList，直接將原本LinkedList的節點依照排序串接起來，可省下O(N)的空間複雜度。

這題算是Merge Sort的進階題，有滿多新發現的~

## 結果
> 06/30/2021 10:55	Accepted	1 ms	40.5 MB	java  
> 時間：100.00% / 空間：73.65%