# p10_Regular Expression Matching

###### tags: `LeetCode` `Hard`

## 題目
[原題目連結](https://leetcode.com/problems/regular-expression-matching/)

給你兩個字串s和p，p是一串正則表達式，請問s有沒有滿足p的表達式?

* `.` 可以表示**任意一個**字元
* `#*` 表示**零到無限多個** #

:::spoiler 測資限制
* 0 <= `s.length` <= 20
* 0 <= `p.length` <= 30
* s只包含英文小寫
* p只包含英文小寫和 `.` 和 `*`
:::

### example
```
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
```

## 解題
我太小看hard的題目了，一開始我以為只要將s和p掃過一遍，同時比對s有沒有符合p就好了。但是後來發現在 `#*` 和 `.*` 因為他們的長度不固定，所以會出現問題。

我後來想到用stack解決問題，將正則表達式切成一個一個區塊，然後用類似深度的方式去搜尋所有可能性，但因為判定太複雜，我花了整整三天才實作出來，最後雖然是AC了，但時間上要60ms(贏了20%)...

最後看Discuss才知道別人是用動態規劃(Dynamic Programing)來解題的，看完覺得真的很神奇，在這邊講解一下他的做法：

[原文](https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation)

首先，建立一個二維陣列dp，其中 `dp[0][0]` 的值代表 s.substring(0, i) 是否符合 p.substring(0, j)。
![](https://i.imgur.com/WDMqNyc.jpg)

第一步，`dp[i][j]` 一定為True，因為 s="" 和 p="" 是符合的

![](https://i.imgur.com/NYc2u2L.jpg)

第二步，先掃過第一列，如果P讀到`*`，則那一個的值會等於前兩個的值。  
因為如果是讀到`*`，可以變成空白，那一定結果會和沒有讀到`*`是一樣的。

![](https://i.imgur.com/kUF7lFK.jpg)

第三步，逐行掃過一遍，基本上會遇到兩種情況：

1. **如果s等於p，或p等於 `.`，則 `dp[i][j] = dp[i - 1][j - 1];`。**  
因為在這一個字元是對符合的，所以只要去掉這個字元是符合的，那結果也是符合的。
2. **如果p等於`*`，則...**
    1. **如果`*`的前一個p是`.`，或前一個s等於p，則`dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];`**  
    因為前一個字相符，所以`*`可以代表三種意思，代表0個(dp[i][j - 2])，代表1個(dp[i][j - 1])，或者代表多個(dp[i - 1][j])。
    2. **如果前一個字不相符，則`dp[i][j] = dp[i][j - 2];`**  
    因為前一個字不相符，所以`*`只能是代表0個(dp[i][j - 2])。
3. **不符合上述情形的都是False。**  

![](https://i.imgur.com/ou4sj2q.jpg)

黃圈1的情況：1
黃圈2的情況：2-1
黃圈3的情況：2-2

最後，`dp[s.length()][p.length()]`就會是答案了。

總之，就是透過二維陣列存放上次的結果，然後利用上次的結果找出下一次的結果，是典型動態規劃的應用。

也有看到其他版本，不過作法都大同小異，就不多講了。

這個當然比我寫得快很多，但不知什麼原因，最快的只有4ms(贏過53.61%)。空間部分因為是二維陣列，表現得也不好。

如果想改進空間就改用遞迴，但相對地時間表現就會變差。

## 結果
> 我自己寫的stack法  
> 06/04/2021 00:48	Accepted	60 ms	40.4 MB	java  
> 時間：20.94% / 空間：??%  

> dp二維陣列法  
> 06/04/2021 02:10	Accepted	4 ms	39.4 MB	java  
> 時間：56.61% / 空間：12.52%  

> 遞迴法  
> 06/04/2021 21:42	Accepted	12 ms	39 MB	java  
> 時間：35.37% / 空間：43.34%  