# p407_Trapping Rain Water II

###### tags: `LeetCode` `Hard`

## 題目
[原題目連結](https://leetcode.com/problems/trapping-rain-water-ii/)

給一個整數的二維矩陣，矩陣中的數字代表地勢高度，請求出下雨過後有多少積水? (谷地的地方就會形成積水)

<details><summary><b>Example 1</b></summary>

![](https://i.imgur.com/vc6zSie.png)

```
Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small ponds 1 and 3 units trapped.
The total volume of water trapped is 4.
```

</details>

<details><summary><b>Example 2</b></summary>

![](https://i.imgur.com/0OJwoji.png)

```
Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
Output: 10
```

</details>

## 解題

這是 [p042_Trapping Rain Water](https://github.com/AndyChiangSH/LeetCode/tree/master/Problem/p042_TrappingRainWater) 的進階版，這兩題都有一定難度，不愧為Hard的題目。

### 一層一層法

最爛的方法，就一次上升一個高度，然後從同高度的節點開始做DFS(或BFS)，檢查看看相連的Component是否有接觸邊界，如果沒有則增加水量，走訪過的點高度就+1，標記為走過了。

因為要掃過整張圖h次，時間複雜度顯然是h\*m\*n。

> **⏳ 時間複雜度：O(h\*m\*n)**  
> **💾 空間複雜度：O(m\*n)**  

> 複雜度太大，直接跑到Timeout


### 一層一層法 (min-heap)

比上一個解法稍微優化一點，使用min-heap紀錄有出現的高度，然後從最低慢慢取到最高，其他的就跟上一個一樣了。

> **⏳ 時間複雜度：O(h\*m\*n)**  
> **💾 空間複雜度：O(m\*n)**  

> 03/07/2022 00:04	Accepted	1483 ms	57.9 MB	java  
> 雖然有過，但慢到不可思議


### 邊界逼近法

好吧，最後還是想不出來，只好去看別人的作法了。

其實這方法跟 [p042_Trapping Rain Water](https://github.com/AndyChiangSH/LeetCode/tree/master/Problem/p042_TrappingRainWater) 的**左邊右邊一次只移動比較小的那邊**方法上很相似。只不過在P042時，我們的邊界是左右兩個邊，在這題邊界的概念擴展到二維，變成四個邊，就像下圖：

![](https://i.imgur.com/Yau2W4n.png)

首先你必須了解，形成積水的基本條件是什麼?

1. **這格高度必須比周圍格子的高度來的低**
2. **積水的高度會等於周圍格子中最低的高度**
3. **四個邊界是絕對不可能形成積水的**

一定要先理解上面這三個條件，才能繼續接下來的講解。

還記得在P042時，我們都先移動最小的邊界嗎? 這是為了滿足條件2，在這題也是一樣的道理，不過我們現在的邊界不再只有兩個了，要從多個邊界中每次挑出最小的邊界，想到了嗎? **就是Heap!**

我們需要建立一個min-heap，在Java中則使用`<PriorityQueue>`。每個Element除了存高度以外，還需要存該格的XY座標，這是為了拿出來時可以知道它的位置。

另外，因為每一格只需要走訪一次就好，於是我們要建立一個visited的二維布林陣列，走訪後就標記為true。

第一步，因為一開始的邊界在最外圍，所以**將最外圍的格子全部加進heap中，且全部標記成visited**。

第二步，從heap中取出最小的格子，並檢查其上下左右的格子**是否在陣列範圍內**以及**是否走訪過**。假設現在檢查上面那格，如果他在陣列範圍內且未走訪過，**則水量就是上面那格高度減去該格子高度**。然後將該點標記為走訪過，並加進heap中(高度為上面那格和該格子高度較高者)，作為新的邊界。

第三步，**如此反覆直到heap中沒有格子，水量總和即為答案**。

重點是，我們要了解為什麼這樣做會是對的?

1. **heap中的格子都作為邊界**
2. **因為min-heap的特性，我們可以保證每次取出的一定是最小邊界**
3. **走訪後標記成走訪過，並加進heap中，相當於BFS向內逼近**

如果還是覺得很抽象，可以參考[這篇Discuss](https://leetcode.com/problems/trapping-rain-water-ii/discuss/1138028/Python3Visualization-BFS-Solution-With-Explanation)，附上圖片相信更好理解。

在資料結構部分要特別注意的是，類別Cell必須定義好compareTo這個函數，讓heap以高度作為排序依據。

[文字解說(英文)](https://leetcode.com/problems/trapping-rain-water-ii/discuss/89495/How-to-get-the-solution-to-2-D-%22Trapping-Rain-Water%22-problem-from-1-D-case)

> **⏳ 時間複雜度：O(m\*n\*log(mn))**  
> 解釋：BFS(m\*n) * Heap(log(n))  
> **💾 空間複雜度：O(m\*n)**  

> 03/08/2022 20:28	Accepted	16 ms	45.1 MB	java  
> **⏳ 時間：96.95%**  
> **💾 空間：90.79.%**  


### Bellman Ford

結果，上面那個竟然還不是最快的!

99%的人都是使用這個方法，有點像**Bellman Ford找最短路徑**的感覺，只能說非常神奇。

首先，會copy一個一模一樣的陣列，叫做volume。

Bellman Ford每一輪會**從左上角掃到右下角**，先取該格上方和左方height較小者，再跟自己的height取大者，如果該值小於自己的volume，則更新volume。**反方向再做一遍(從右下角掃到左上角)**，比較該格的下方和右方height。這樣即為一輪。

**直到某一輪完全沒有更新volume，則結束Bellman Ford。**

最後，**每一格的 volume - height 的總和就是答案**。

> **⏳ 時間複雜度：O(m\*n\*r), r=Bellman Ford次數**  
> **💾 空間複雜度：O(m\*n)**  

> 03/09/2022 18:34	Accepted	9 ms	56 MB	java  
> **⏳ 時間：99.24%**  
> **💾 空間：8.10%**  


## 後記

這題需要靈活運用heap在BFS上，將heap視為特殊的queue，這是我未曾想過的方法。除此之外，Bellman Ford的方法也非常聰明。總之，是相當好的一個題目。