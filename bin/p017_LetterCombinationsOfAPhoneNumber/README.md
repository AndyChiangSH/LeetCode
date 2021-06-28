# p17_Letter Combinations of a Phone Number

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

回想一下電話的數字按鍵，底下是不是有幾個小小的英文字母呢? 那些英文字母是你按那個數字可以打出的英文字母。

現在，給你一串數字順序，請求出按照數字順序輸入，所有可能產生的英文組合。

參考圖片如下

![](https://i.imgur.com/qmKIIyg.png)

## 解題
看到這幾個關鍵字 **"照順序"、"所有可能"**，馬上就要聯想到 **遞迴** 了。

知道用遞迴後就簡單啦，每遞迴一層，就對第一個數字做展開(數字對應可能的英文字母)，每個可能性再往下遞迴，然後用字串紀錄現在的英文字母是多少，最後，數字整個跑完，遞迴結束。

畫成圖大概是這樣：

![](https://i.imgur.com/eVlPNPx.jpg)

一些小發現：
* 數字字串不用每次遞迴都移除第一個數字，只要將目前到第幾個數字的index記起來，每次遞迴+1就好了，對String的操作越少就越好。
* **StringBuilder is god!!!** 超級快又超級省記憶體，根本跟String是不同次元的東西，不用白不用。

## 結果
> 亮眼成績
> 06/11/2021 00:21	Accepted	0 ms	37.3 MB	java  
> 時間：100.00% / 空間：95.92%