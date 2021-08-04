# p079_Word Search

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/word-search/)

給你一個字元陣列`board[][]`和字串`word`，請求出board中是否包含word。

單字必須是連續的，連續是指上下左右相鄰。

![](https://i.imgur.com/3ih4m26.png)

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
```

## 解題
### DFS
這題一看就是DFS問題，之前也做過好多次了，就不用多說了吧?

簡單講，就是從一個符合第一個字元的點當起點，然後檢查上下左右是否符合word下一個字元，符合的話則遞迴下去，如果長度等於word的長度就找到了。當作在走迷宮就很容易。

我想談比較有趣的部份在於標記走過的部分，最簡單是一個布林陣列標記，但這樣會浪費額外空間。比較好的方法是，**直接將board的值設為 `*`** (只要不是英文字母的符號皆可)，**但在覆蓋之前先將值存進temp中，結束時再從temp取值補上去就好**，因為標記走過跟清除走過是在同一個遞迴中，因此這麼做完全沒問題。

> **⏳ 時間複雜度：O(M\*N\*L)**  
> **💾 空間複雜度：O(M\*N)**  
> `M=board.length`, `N=board[0].length`, `L=word.length`

## 結果
### DFS

> 08/04/2021 10:52	Accepted	52 ms	37 MB	java  
> **⏳ 時間：97.02%**  
> **💾 空間：60.90%**  

## 後記