# p034_Find First and Last Position of Element in Sorted Array

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

給你一個排序好的陣列`nums[]`和一個整數`target`，請求出`target`在`nums[]`的區間`[first index, last index]`，如果找不到則回傳`[-1, -1]`。

**時間複雜度必須在O(logN)以下。**

## 解題
延續p033後，又是一題二元搜尋的進階題，這次是之前沒看過的題型，解題過程非常的有趣。

首先我們來看找到target會有幾種情況：
```
1. target在區間正中間
[1, 2, 2, 2, 3]
       ^
必須往左邊找first index，和往右邊找last index。

2. target在區間最後一個
[1, 2, 2, 3, 3]
       ^
找到了last index，接著必須往左邊找first index。

3. target在區間第一個
[1, 1, 2, 2, 3]
       ^
找到了first index，接著必須右邊找last index。

4. target只有一個
[1, 1, 2, 3, 3]
       ^ 
找到了first index和last index，直接回傳。
```

好，那麼接下來寫兩個函式分別往左邊和往右邊找。

往左邊的部分：
```
1. 如果mid小於target，則表示first index在右邊。
[1, 1, 1, 2, 2]
       ^

2. 如果mid等於target，但是在區段中間，則表示first index在左邊。
[1, 1, 2, 2, 2]
       ^
```

往右邊的部分：
```
1. 如果mid大於target，則表示last index在左邊。
[2, 2, 3, 3, 3]
       ^

2. 如果mid等於target，但是在區段中間，則表示last index在右邊。
[2, 2, 2, 3, 3]
       ^
```

兩個函式分別回傳first index和last index，最後回傳`[first index, last index]`。

## 結果
> 07/06/2021 00:14	Accepted	0 ms	42.2 MB	java  
> 時間：100.00% / 空間：64.48%