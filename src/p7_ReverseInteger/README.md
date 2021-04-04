# p7_Reverse Integer

###### tags: `LeetCode`

## 題目
[原題目連結](https://leetcode.com/problems/reverse-integer/)

給定一個整數x，請你求出x反轉後的值，如果反轉後的值超過int範圍，則回傳0。

* -2^31^ <= x <= 2^31^ - 1
* x只能是32bit儲存

Example 1:
```
Input: x = 123
Output: 321
```

Example 2:
```
Input: x = 120
Output: 21
```

## 解題
反轉數字本身很簡單，做法是宣告一個整數rev為0，並讓rev等於rev乘10加上x取10的餘數，x等於0就結束。

超過範圍的部分，我的作法是將x反轉後再反轉回來，檢查這兩個數字是否相同，我知道，這方法很蠢，但時間卻贏了90幾%。

後來看了一下其他解法，發現其他人是檢查rev在加之前有沒有大於MAX_INT/10或小於MIN_INT/10，並檢查最後一個位元是否大於7或小於-8，只需要一次反轉就可以，時間贏了100%。

## 結果
> 04/04/2021 18:53	Accepted	1 ms	36.3 MB	java
> 時間贏了94.68%，空間贏了35.63%

> 04/04/2021 19:00	Accepted	1 ms	35.8 MB	java
> 時間贏了100%，空間贏了94.39%