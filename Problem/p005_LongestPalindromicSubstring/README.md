# p5_Longest Palindromic Substring(LSP)

###### tags: `LeetCode`

## 題目
[原題目連結](https://leetcode.com/problems/longest-palindromic-substring/)

給定一個字串s，請求出s的最長回文子字串。

例如:  
```
Input: s = "babad"
Output: "bab"
```
```
Input: s = "abbabc"
Output: "abba"
```

* s的長度不超過1000
* s只包含英文字母(大小寫)

## 解題
解這題的演算法有很多，當然最垃圾的解法就是每一個點當中心，算該點的最大回文長度，但複雜度顯然就是O(N^2^)。

所以我採用的是Manacher’s Algorithm，時間複雜度為O(N)。
該方法很有趣，用到動態規劃(DP)的概念，但我這裡沒時間多說，網路上就有很多相關文章了，我把連結留在下面。

* [維基百科_LSP](https://zh.wikipedia.org/wiki/%E6%9C%80%E9%95%BF%E5%9B%9E%E6%96%87%E5%AD%90%E4%B8%B2)
* [Leetcode No.322( Longest Palindromic Substring) 心得(Medium)](https://medium.com/@ChYuan/leetcode-no-322-longest-palindromic-substring-%E5%BF%83%E5%BE%97-medium-3ff9eff34230)
* [[演算法] Manacher’s Algorithm 筆記](https://medium.com/hoskiss-stand/manacher-299cf75db97e)
* [GeeksforGeeks_Manacher’s Algorithm](https://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-1/)
* [簡體說明](https://www.felix021.com/blog/read.php?2040)
* [YT影片](https://www.youtube.com/watch?v=V-sEwsca1ak)

## 結果
> 03/30/2021 12:19	Accepted	9 ms	39.2 MB	java  
> 時間贏了97.40%，空間贏了66.78%