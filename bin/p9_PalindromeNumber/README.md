# p9_Palindrome Number

###### tags: `LeetCode`

## 題目
[原題目連結](https://leetcode.com/problems/palindrome-number/)

給你一個數字x，請告訴我x是不是回文。

### example 1
```java
Input: x = 121
Output: true
```

### example 2
```java
Input: x = -121
Output: false
```

## 解題
觀察範例可以發現只要是**負數**就絕對不會是回文。

### 字串比較法
直接將數字轉為字串，第一個和倒數第一個比，第二個和倒數第二個比...依此類推。

缺點是數字轉字串要花較長時間。

### 反轉法
將x反轉，如果跟原x一樣的話就是回文，反之則不是。

## 結果
> 字串比較法  
> 04/21/2021 19:30	Accepted	7 ms	38.5 MB	java  
> 時間:64.61%，空間:31.86%

> 反轉法  
> 04/21/2021 20:05	Accepted	6 ms	38.4 MB	java  
> 時間:99.96%，空間:41.99%

因為題目太簡單了，所以差1毫秒就從99%掉到64% 😅