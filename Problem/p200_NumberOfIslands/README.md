# p200_Number of Islands

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/number-of-islands/)

輸入是一個二維陣列，其中0代表海洋，1則代表陸地，請你求出島嶼的數量(四周相連的陸地即形成島嶼)。

<details><summary><b>Example 1</b></summary>
    
```
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
```

</details>

<details><summary><b>Example 2</b></summary>
    
```
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
```

</details>

## 解題

這題換個角度看其實就是找圖中的component，就把二維陣列想成每個點都和其上下左右相連的無向圖就可以了。講到找component，不外乎就是BFS、DFS或Union-Find了。

### BFS解

BFS就不多說了吧，使用一個Queue，走訪過的就改成0，最後算BFS幾次就好。

但因為引用Queue的原因，比DFS慢...。

> **⏳ 時間複雜度：O(n\*m)**  
> **💾 空間複雜度：O(n\*m)**  

> 03/02/2022 20:43	Accepted	8 ms	56.7 MB	java  
> **⏳ 時間：27.93%**  
> **💾 空間：37.59%**  

### DFS解

DFS和BFS作法大同小異，不過因為用遞迴就好，所以速度比BFS還快。

> **⏳ 時間複雜度：O(n\*m)**  
> **💾 空間複雜度：O(n\*m)**  

> 03/02/2022 21:00	Accepted	2 ms	50.9 MB	java  
> **⏳ 時間：99.99%**  
> **💾 空間：81.23%**  

### Union-Find解

找到別人寫的Union-Find，雖說可以通過，但講實話就是又麻煩又慢。

> **⏳ 時間複雜度：O(n\*m\*log(n))**  
> **💾 空間複雜度：O(n\*m)**  

> 03/02/2022 20:43	Accepted	8 ms	56.7 MB	java  
> **⏳ 時間：21.92%**  
> **💾 空間：20.99%**  

## 後記

滿普通的一個題目，沒什麼有趣的解法。