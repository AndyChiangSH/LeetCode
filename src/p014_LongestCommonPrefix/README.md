# p14_Longest Common Prefix

###### tags: `LeetCode` `Easy`

## 題目
[原題目連結](https://leetcode.com/problems/longest-common-prefix/)

題目給你一個字串的陣列，請求出符合所有字串最長的前綴(ㄓㄨㄟˋ)字。

什麼是前綴字? 直接看例子就知道了。
```
Input: strs = ["flower","flow","flight"]
Output: "fl"
```
因為 "flower", "flow", "flight" 前兩個字都是 "fl"，但第三個字之後就不一樣了，所以答案就是 "fl"。

## 解題
### 我的寫法
一開始沒想太多，就直接兩個迴圈，從頭一個字一個字去比，但結果就是超慢...。

### 大老的寫法
**先將陣列排序過(這點很重要!!)**，然後找出**第一個和最後一個的最長前綴字**即為答案。

後來想想還真的可行，舉以下例子：
```
strs = ["abcde", "abc", "abcd", "abdc"]

After sorting...

abc  -> 第一個
abcd
abcde
abdc -> 最後一個

abc 和 abdc 的最長前綴 = ab
```

我的寫法的複雜度：O(M\*N) (M=字串數量，N=最長字串長度)
大老寫法的複雜度：O(MlogM+N) (M=字串數量，N=第一個和最後一個字串較長的長度)

雖然不知道Java預設sort複雜度是多少，**但大老寫法真的有比較快!**

[原始出處](https://leetcode.com/problems/longest-common-prefix/discuss/721752/Java-100-just-compare-two-strings)

## 結果
> 我的  
> 06/08/2021 23:56	Accepted	8 ms	39.2 MB	java  
> 時間：18.13% / 空間：9.90%

> 大老的  
> 06/09/2021 00:07	Accepted	1 ms	37.1 MB	java 
> 時間：59.45% / 空間：52.10%

一些小發現：
* 使用 str1 + str2 超級慢~~~
* StringBuilder比較快