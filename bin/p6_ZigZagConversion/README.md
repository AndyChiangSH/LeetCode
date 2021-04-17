# p6_ZigZag Conversion

###### tags: `LeetCode`

## 題目
[原題目連結](https://leetcode.com/problems/zigzag-conversion/)

給你一個字串(s)和行數(numRows)，請求出他以鋸齒狀(ZigZag)排序之後(高度需為numRows)，從上到下從左到右的順序。

什麼是鋸齒狀排列? 如以下範例：
```
P   A   H   N
A P L S I I G
Y   I   R
```
會以像是倒轉的N一樣排序。

範例：
```
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
```

## 解題
說實在的，我覺得這題不難，因為就只是單純地找規律而已，而且我一畫圖出來馬上就發現了。

我猜他應該是想騙我用二維陣列存鋸齒狀的排序，只是很可惜的，我完全不需要用到二維陣列就完成了，且時間複雜度為O(N)。

只要畫圖出來就能很輕易地找出規律：

![](https://i.imgur.com/vyGghFt.jpg)

設定兩個變數，一個索引值從8開始每次減2，直到為0，另一個索引值從0開始每次加2，直到為8，每一行都是這兩個變數交錯出現。

第一行和最後一行較特殊，每次索引值只需要加上8即可，可以由 (numRows-1)\*2 得到8這個數字。

另外就是要小心陣列out of range的問題，我的作法是如果超出範圍就跳出迴圈(結束此行)。

第一次WA，因為少考慮到字串為"A"，而行數為2的情況，將跳出條件改成先檢查後解決。

## 結果
> 03/31/2021 00:31	Accepted	2 ms	39.3 MB	java  
> 時間99.90%，空間83.23%

結果超快的，第一次交時間和空間就在80%以上。