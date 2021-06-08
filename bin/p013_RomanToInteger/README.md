# p13_Roman to Integer

###### tags: `LeetCode` `Easy`

## 題目
[原題目連結](https://leetcode.com/problems/roman-to-integer/)

請你將羅馬字母轉為正確的數值。

羅馬字母和數值對照表：
```
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```

比較特殊的情況：
```
IV = 4
IX = 9
XL = 40
XC = 90
CD = 400
MD = 900
```

## 解題
### 我自己的寫法
每個羅馬字母都有一個變數紀錄讀到幾個字，但如果在I前面有V的話，則紀錄為-1，最後將每筆紀錄乘上每個羅馬字母的權重，總和就是答案了。

但大概是因為每個字都要比較，速度比較慢。

### 大老的寫法
在Discuss中看到一個滿有趣的寫法：

多紀錄前一個字母，如果V的前一個字母是I，則回傳的值為`5(代表值) - 1(I在前面本來就-1) - 1(補扣前一個I多加的部分) = 3`，否則回傳`5(代表值)`。其他字母也是依此類推。

少了比較和一大堆變數，無論在空間還是時間上都提升許多!

## 結果
> 我的寫法  
> 06/08/2021 22:59	Accepted	7 ms	41.7 MB	java  
> 時間：24.44% / 空間：10.12%

> 大老的寫法  
> 06/08/2021 23:13	Accepted	3 ms	38.8 MB	java  
> 時間：99.83% / 空間：89.36%

一些小發現：
* 字串轉成字元陣列比較快