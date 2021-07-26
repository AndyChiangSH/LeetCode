# p056_Merge Intervals

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/merge-intervals/)

給你一個整數的二維陣列intervals，`intervals[i] = [start, end]`代表一段區間，從start到end。區間重疊則合併為更大的區間，請求出所有區間合併後所剩的區間。

## 解題
這題重點在於要先排序好，排序規則如下：

* **起點小的優先排於前面。**
* **若起點一樣大，則讓終點小的排於前面。**

接著只要判斷區間有沒有合併就好了，因為排序好了，不必擔心有合併到更前面的區間的情況。

* 如果起點小於上一個區間，**表示兩區間重疊**，max = MAX(max, end)。
* 否則，**兩區間不重疊**，產生新的區間出來，max = end, min = start。

### 排序
因為`Array.sort()`不支援二維陣列排序，這部分要自己實作。

所以我做了Merge sort和Quick sort版本，實際跑起來都差不多。

#### ⏳ 時間複雜度：O(N), N = intervals.length
#### 💾 空間複雜度：O(N), N = intervals.length

## 結果
> 07/23/2021 11:15	Accepted	3 ms	40.7 MB	java

#### ⏳ 時間：98.63%
#### 💾 空間：99.70%

## 後記
發現arraylist to array的方法 `answer.toArray(new int[answer.size()][2])`。