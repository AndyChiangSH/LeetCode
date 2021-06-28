# p22_Generate Parentheses

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/generate-parentheses/)

給數字N，請你求出所有N組括號可以產生的合法組合。

* `1 <= N <= 8`

## 解題
看第一眼馬上想到的是DFS解法，就像是二元樹一樣將所有合法的組合找出來，其實可以想得更簡單一點，就好像你在走迷宮，你只有三次往上和三次往前的機會，不能往下或往後走，問題是求出所有可走的路徑，在這個例子中，往上代表加上 `(` ，往前則代表 `)`。

但也不是所有路徑都能走，如果 `)` 的數量大於 `(` 的數量，就肯定是不能走的! 因為會產生像 `())` 這種不合法的組合。

當 `)` 和 `(` 的數量都等於N時，表示走到終點了，也就是產生一個新的組合。

所以最後圖長這樣：

![](https://i.imgur.com/W9zUgd2.jpg)

用遞迴下去很快就能找出所有組合了~

還有一種[DP的解法](https://leetcode.com/problems/generate-parentheses/discuss/10369/Clean-Python-DP-Solution?)，滿有趣的，有興趣可以去看看。

## 結果
> DFS  
> 06/28/2021 23:43	Accepted	0 ms	38.9 MB	java  
> 時間：100% / 空間：88.30%

> DP  
> 06/29/2021 00:36	Accepted	7 ms	39 MB	java  
> 時間：12.56% / 空間：77.70%