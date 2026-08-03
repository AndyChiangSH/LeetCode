# [877. Stone Game](https://leetcode.com/problems/stone-game/description/)

###### tags: `LeetCode` `Medium`

## Intuition

<!-- Describe your first thoughts on how to solve this problem. -->

這題是兩個人輪流拿石頭的遊戲，Alice 和 Bob 每次只能拿最左邊或最右邊的一堆石頭，而且兩個人都會使用最佳策略。

第一個想到的是用動態規劃，計算每一個區間中，目前玩家最多可以取得多少分數差。

不過仔細觀察題目的條件後，會發現其實 Alice 一定可以獲勝，甚至不需要真的模擬整個遊戲。

## Solution 1

<!-- Describe your approach to solving the problem. -->

先使用動態規劃模擬 Alice 和 Bob 都採取最佳策略的情況。

我們把 Alice 拿到的石頭視為正分，Bob 拿到的石頭視為負分。

定義：

```python
dp[i][j]
```

表示只剩下 `piles[i]` 到 `piles[j]` 時，Alice 最後能取得的最大分數差。

當只剩下一堆石頭時，當前玩家只能拿走這一堆。

接著根據目前是 Alice 還是 Bob 的回合決定轉移方式。

如果是 Alice 的回合，她會希望自己的分數最大，因此可以選擇：

```python
piles[i] + dp[i + 1][j]
```

或：

```python
piles[j] + dp[i][j - 1]
```

並取兩者中的最大值。

如果是 Bob 的回合，Bob 拿到的石頭會從 Alice 的分數中扣除，而且 Bob 會希望 Alice 的分數越小越好，因此可以選擇：

```python
-piles[i] + dp[i + 1][j]
```

或：

```python
-piles[j] + dp[i][j - 1]
```

並取兩者中的最小值。

最後如果 `dp[0][n - 1] > 0`，代表 Alice 最後取得的石頭比 Bob 多，因此 Alice 獲勝。

### Code

```python []
class Solution:
    def stoneGame(self, piles):
        N = len(piles)

        def dp(i, j):
            # The value of the game [piles[i], piles[i+1], ..., piles[j]].
            if i > j:
                return 0
            parity = (j - i - N) % 2
            if parity == 1:  # first player
                return max(piles[i] + dp(i+1, j), piles[j] + dp(i, j-1))
            else:
                return min(-piles[i] + dp(i+1, j), -piles[j] + dp(i, j-1))

        return dp(0, N - 1) > 0
```

### Complexity

* Time complexity: $$O(n^2)$$

* Space complexity: $$O(n^2)$$

### Result

> Time Limit Exceeded 26 / 46 testcases passed

## Solution 2

<!-- Describe your approach to solving the problem. -->

不過這題其實不需要使用動態規劃，因為根據題目的條件，Alice 一定會獲勝。

我們可以把所有石頭堆按照位置分成兩組：

* 偶數索引：`piles[0]`、`piles[2]`、`piles[4]`……
* 奇數索引：`piles[1]`、`piles[3]`、`piles[5]`……

因為石頭堆的數量是偶數，所以最左邊和最右邊的索引奇偶性一定不同。

Alice 在第一回合可以選擇最左邊或最右邊，因此她可以決定自己之後要拿偶數索引的石頭，還是奇數索引的石頭。

例如 Alice 想拿偶數索引的石頭，她第一回合就選擇位於偶數索引的那一端。

之後不管 Bob 選擇哪一邊，Alice 都可以繼續選擇對應的位置，最後拿到所有偶數索引的石頭。

同理，她也可以選擇拿到所有奇數索引的石頭。

因為題目保證所有石頭的總和是奇數，所以偶數索引和奇數索引的石頭總和不可能相等。

因此其中一組的總和一定比較大，Alice 只要選擇總和較大的那一組，就一定能夠獲勝。

所以答案可以直接回傳 `True`。

### Code

```python []
class Solution(object):
    def stoneGame(self, piles):
        """
        :type piles: List[int]
        :rtype: bool
        """
        
        return True
```

### Complexity

* Time complexity: $$O(1)$$

* Space complexity: $$O(1)$$

### Result

> Accepted 46 / 46 testcases passed  
> Runtime 0 ms | Beats 100.00%  
> Memory 12.32 MB | Beats 70.20%  

---

<div align="center">
<sub>Date: 2026/08/03</sub>
<br>
<sub>Author: Andy Chiang</sub>
</div>
