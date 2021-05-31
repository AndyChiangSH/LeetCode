# p3_LongestSubstringWithoutRepeatingCharacters

###### tags: `LeetCode`

## 題目
[原題目連結](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

給定一個字串，請找出最大連續不重複子字串的長度。

比方說
Input: "pwwkew"
Output: 3
因為 "wke" 為符合條件的子字串，因此回傳長度為3。

## 解題

一開始我的想法是一個for迴圈，讓i一直往前跑，結果交出去就WA了...

後來發現在 "dvdf" 這筆測資出問題，原來是我少考慮了前面的狀況，以此測資為例，當i跑到第二個d時，會將長度歸零，這樣做的結果是2，而不是3。

於是我找了一下人家的code，發現有個大老用類似Queue的概念寫，複雜度只有O(N)，真的超猛的。

## 結果
> 03/25/2021 01:58	Accepted	4 ms	39 MB	java

> 03/25/2021 01:28	Wrong Answer	N/A	N/A	java