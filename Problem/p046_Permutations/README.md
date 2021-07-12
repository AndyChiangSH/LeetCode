# p042_Trapping Rain Water

###### tags: `LeetCode` `Hard`

## 題目
[原題目連結](https://leetcode.com/problems/trapping-rain-water/)

給你一個整數陣列`height[]`，陣列中的數字代表著牆的高度，索引值代表X座標。

請求出全部的牆可以累積的水量。

<details><summary><b>example 1</b></summary>

![](https://i.imgur.com/BiVRaSi.png)

```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
```

黑色區塊代表牆，藍色區塊代表水，圖中最多可累積6格水，所以答案是6。

</details>

<details><summary><b>example 2</b></summary>

```
Input: height = [4,2,0,3,2,5]
Output: 9
```

</details>

## 解題
這題和 [p11_Container With Most Water](https://github.com/AndyChiangSH/LeetCode/tree/master/Problem/p011_ContainerWithMostWater) 非常像，但是這題求的是所有可以累積的水量。

一開始我想說用和第11題一樣的思路下去解，前部分沒什麼問題，但當左右相遇時，因為左右的水面高度不一樣，加上又有到底是重疊還是交錯的問題，使得將左右的水量融合變成一件非常困難的事(必須要很多判斷式)。

### 左邊右邊夾擊，再把中間的水池掃一遍
> Solution2

後來我就放棄了想判斷式，改成說左右交會後，用左右的最大水面高度較小的那個在掃描一遍中間尚未融合的這段，順利的解決了融合的問題。

左右夾擊的成本是O(N)，掃描一遍中間在最壞情況下是O(N)，總共是**O(2N)**。

但看的出來這樣並不夠好，在最壞情況下第一次左右夾擊根本是浪費的。

### 左邊右邊一次只移動比較小的那邊
> Solution4

為什麼會有需要融合的問題，是因為我一直卡在左右一定要同時向內逼近這個思路底下，但實際上，真的一定要這樣嗎?

後來發現，其實只要左邊右邊一次只移動比較小的那邊，直到左右交會，水量的總和就會是答案了。

看圖來說明：  
假設圖一開始長這樣
![](https://i.imgur.com/mCtVHYu.jpg)

因為此時left < right，所以left向中間移動到下一個比left大的位置(紅色方塊)，兩者中間的藍色線條代表水面高度。

![](https://i.imgur.com/qlyPeV9.jpg)

因為現在right < left了，所以改成由right向中間移動到下一個比right大的位置(紅色方塊)。

![](https://i.imgur.com/LZ0vZkZ.jpg)

因為此時又left < right，所以left向中間移動到下一個比left大的位置(紅色方塊)，最後left和right交會，結束迴圈。

![](https://i.imgur.com/KpELWJA.jpg)

藍色線條底下的範圍就是累積水量了。複雜度只有**O(N)**。

### DP法
> Solution3

和演算法作業的[Buy Phone](https://github.com/AndyChiangSH/1092_Algorithm/tree/master/src/hw07) 類似概念，先從尾端向後計算rmax，並存在陣列中，再從頭向前計算lmax，min(lmax, rmax)-height得到水量，將所有水量加總即為答案。

```
height  0 1 0 2 1 0 1 3 2 1 2 1
rmax    3 3 3 3 3 3 3 3 2 2 2 1
lmax    0 1 1 2 2 2 2 3 3 3 3 3
water   0 0 1 0 1 2 1 0 0 1 0 0

totalWater = 1+1+2+1+1 = 6
```

因為來回掃描兩遍，時間複雜度是**O(2N)**，空間複雜度是O(N)。

### Stack法
> Solution5

這個想法很奇特，算水量的方式不像前幾個方法是垂直的算，而是水平的算，並用stack去紀錄前面的index，大概畫圖講一下概念。

原圖長這樣：

![](https://i.imgur.com/H1gnsVY.jpg)

當自己小於stack的top時，就push進stack，所以4, 2, 1都在stack中了。

![](https://i.imgur.com/ro6xU5T.jpg)

當自己大於stack的top時，就把stack中比自己小的數字都pop出來，並換算水量(計算公式稍微複雜，還是看程式碼理解比較好)，最後把自己push進去，所以3會把1, 2給pop出來，push 3進去。

![](https://i.imgur.com/1U3dMiQ.jpg)

讀到4也是一樣的。

![](https://i.imgur.com/sHCr6pk.jpg)

藍色區塊加總即為答案。

## 結果
> 左邊右邊夾擊，再把中間的水池掃一遍  
> 07/12/2021 17:11	Accepted	2 ms	39.8 MB	java  
> 時間：27.21% / 空間：16.98%

> 左邊右邊一次只移動比較小的那邊  
> 07/12/2021 18:18	Accepted	1 ms	38.4 MB	java  
> 時間：85.00% / 空間：79.72%

> DP法  
> 07/12/2021 17:34	Accepted	0 ms	38.9 MB	java  
> 時間：100.00% / 空間：28.46%

> Stack法  
> 07/12/2021 21:32	Accepted	2 ms	38.6 MB	java  
> 時間：27.21% / 空間：58.05%

## 後記
這題滿有趣的，有很多種不同的解法，我覺得我的思路太過局限了，之後要多想想看有沒有別的可能性。