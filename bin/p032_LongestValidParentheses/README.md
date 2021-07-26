# p032_Longest Valid Parentheses

###### tags: `LeetCode` `Hard`

## 題目
[原題目連結](https://leetcode.com/problems/longest-valid-parentheses/)

給你一個由 `(` 和 `)` 所組成的字串s，請你求出在字串中最長的有效子字串。

## 解題
有兩種方法可以解這題。

### Stack
這題跟[p020_Valid Parentheses](https://github.com/AndyChiangSH/LeetCode/tree/master/Problem/p020_ValidParentheses)很相似，所以我套用了類似的概念，利用一個stack，當遇到 `(` 就放入stack，遇到 `)` 則檢查stack的top是不是 `)` ，如果是則組成一對(相消)，不是的話就放入stack。

這樣到最後，**stack中只會留下不符合的符號**，**不符合的符號間的距離就是符合子字串的長度了**，所以我stack中不是放符號，而是符號在s內的index，前後index相減就可以得到符合子字串的長度。求其中最大的就好。

* **時間複雜度：O(2N) = O(N)**, N = s.length() -> 掃過一遍s + stack.pop()
* **空間複雜度：O(N)**, N = s.length() -> stack的空間

### DP
或者是使用動態規劃的解法，**我使用一個一維陣列`dp[]`，記錄了該點目前的最長符合子字串，count用來記錄左掛號的數量**，我們會遇到幾種情況：

* 遇到 `(`：因為 `(` 不會形成一對，所以將`count++`。
* 遇到 `)`：有可能會形成一對，`count--`，又有分成兩種情況：
    * 被包裹起來的情況，像是 `(())`，`dp[i] = dp[i-1]+2`。
    * 前面有連續符合的子字串的情況，像是 `()()`，`dp+=dp[i-dp[i]]`，**注意這裡的 `i-dp[i]` 代表當前位置減去自己累積的長度，就等同於前一個連續符合的子字串的位置。**
* 最後求dp中最大的數字即為答案。

這樣講好像還是不夠清楚，我想直接講流程會比較好懂：

```
String s = "()(())"

i = 0, count = 0
[0, 0, 0, 0, 0, 0]
// 遇到 '('，count++

i = 1, count = 1
i-dp[i] = -1
[0, 2, 0, 0, 0, 0]
// 遇到 ')'，此時count > 0，所以dp[1] = dp[0](0)+2 = 2；
// 但i-dp[i] = -1 < 0(overflow)，所以不加
// count--

i = 2, count = 0
[0, 2, 0, 0, 0, 0]
// 遇到 '('，count++

i = 3, count = 1
[0, 2, 0, 0, 0, 0]
// 遇到 '('，count++

i = 4, count = 2
i-dp[i] = 2
[0, 2, 0, 0, 2, 0]
// 遇到 ')'，此時count > 0，所以dp[4] = dp[3](0)+2 = 2；
// i-dp[i] == 2 > 0，所以dp[i] += dp[2](0) = 2
// count--

i = 5, count = 1
i-dp[i] = 1
[0, 2, 0, 0, 2, 6]
// 遇到 ')'，此時count > 0，所以dp[5] = dp[4](2)+2 = 4；
// i-dp[i] == 1 > 0，所以dp[5] += dp[1](2) = 6
// count--

answer = 6
```

* **時間複雜度：O(N)**, N = s.length() -> 掃過一遍s
* **空間複雜度：O(N)**, N = s.length() -> dp的空間

## 結果
> Stack  
> 07/19/2021 10:25	Accepted	3 ms	38.9 MB	java  

* 時間：36.13%
* 空間：78.26%

> DP  
> 07/19/2021 11:28	Accepted	1 ms	38.9 MB	java  

* 時間：100.00%
* 空間：66.96%

## 後記
stack很直覺就想得出來，但DP真的就要動點腦筋了。