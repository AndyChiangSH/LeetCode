# p128_Longest Consecutive Sequence

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/longest-consecutive-sequence/)

給一個**未排序**的陣列`nums`，請你求出陣列中的**最長連續元素序列**。

**時間複雜度必須為O(n)!**

<details><summary><b>Example 1</b></summary>
    
```
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
```

</details>

<details><summary><b>Example 2</b></summary>
    
```
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
```

</details>

## 解題
### Sort解

最直覺想到的解法當然就是先排序好，然後掃過一遍找連續的就好。但顯然排序的複雜度是**O(n\*log(n))**，馬上被打臉~

> **⏳ 時間複雜度：O(n\*log(n))**  
> **💾 空間複雜度：O(n)**  

### HashMap解

然後就想到用HashMap，紀錄每個數字是否被走訪過。如果有走過就不走了；如果沒有則往前後找連續的數字，走過後標記成走訪過，如此一來就不會有重複的問題。

因為要做 **把數字加進HashMap**、**走過一遍陣列**和**往前後找連續的數字**，時間複雜度是**O(3n)**。空間複雜度是陣列+HashMap，所以是**O(2n)**。

> **⏳ 時間複雜度：O(3n)**  
> **💾 空間複雜度：O(2n)**  

### Set解

本來以為這題就這樣，想不到還有Set的做法，而且這做法還滿好的!

將數字加入一個Set，然後走訪整個陣列，**找到一個數字n，陣列中沒有n-1，並往前找連續的數字**。這樣子，一定是從一個連續序列的最小值開始往後找，就也不需要mark了。時間複雜度僅**O(2n)**，比HashMap還要好!!

結果...慢到哭...，我猜可能是`set.contains()`很慢吧? 不然真的想不到原因。

> **⏳ 時間複雜度：O(2n)**  
> **💾 空間複雜度：O(2n)**  

## 結果
### 👑 Sort解

> 03/02/2022 15:48	Accepted	13 ms	61.7 MB	java  
> **⏳ 時間：96.43%**  
> **💾 空間：41.19%**  

### HashMap解

> 03/02/2022 16:40	Accepted	17 ms	58.7 MB	java  
> **⏳ 時間：86.35%**  
> **💾 空間：75.22%**  

### Set解

> 03/02/2022 17:02	Accepted	453 ms	147.3 MB	java  
> **⏳ 時間：27.40%**  
> **💾 空間：17.69%**  

## 後記

結果前幾名都是Sort，對LeetCode的跑分系統有點無言...