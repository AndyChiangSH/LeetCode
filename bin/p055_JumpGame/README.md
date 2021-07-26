# p055_Jump Game

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/jump-game/)

給你一個正整數陣列`nums[]`，數字代表可跳躍的最大距離，請求出是否存在一種跳法的順序可以到達最後一個index。

## 解題
### DP
用一個陣列`dp[]`紀錄每個點可跳躍的最大距離，然後每次檢查有沒有點可以到達終點，有則回傳true，最後都沒有則回傳false。

### Farthest reachable index(FRI)
最遠可接觸索引值，顧名思義就是 **現在位置(i)+現在位置可跳躍的最大距離(nums[i])**。假如i超過FRI，則不可能接觸到終點(中間斷掉了)。

### Latest reachable index(LRI)
最後可接觸索引值，指的是 `i+nums[i] >= last`，前面的接觸範圍有覆蓋到上一個可接觸索引值，因此範圍可以延伸下去，最後如果 `last == 0` (範圍涵蓋起點和終點)，則起點和終點間就有一條路徑。

## 結果
> 07/22/2021 11:10	Accepted	1 ms	39.5 MB	java

* 時間：100.00%
* 空間：86.92%

![](https://i.imgur.com/V4m2gU3.png)

## 後記
其實有沒有寫防呆好像沒有影響太多(我猜LeetCode也沒有出太極端的測資)。