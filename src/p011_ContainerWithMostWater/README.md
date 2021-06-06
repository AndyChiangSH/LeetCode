# p11_Container With Most Water

###### tags: `LeetCode` `Medium`

## 題目
[原題目連結](https://leetcode.com/problems/container-with-most-water/)

給你一個整數的陣列，陣列中的數字代表牆的高度，索引值代表X座標。

請你求出兩道牆所能容納的最大水量。

<details><summary><b>example 1</b></summary>

![](https://i.imgur.com/jjBg2ca.png)

```
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
```

紅色的兩道牆所能容納的水量為 ((8-1)\*7) = 49，是最大可容納的水量。
不挑 (1,8) 和 (6,8) 是因為 ((6-1)\*8) = 40，比49來的小。

</details>

<details><summary><b>example 2</b></summary>

```
Input: height = [1,1]
Output: 1
```

</details>

<details><summary><b>example 3</b></summary>

```
Input: height = [4,3,2,1,4]
Output: 16
```

</details>

<details><summary><b>example 4</b></summary>

```
Input: height = [1,2,1]
Output: 2
```

</details>

### 測資限制
* `n == height.length`
* `2 <= n <= 105`
* `0 <= height[i] <= 104`

## 解題
因為之前演算法作業有寫過 Buy Phone，很快就想出解法了~

首先，left從頭開始，right從尾端開始，從兩側向內夾擊，直到左右各找到一對大於目前水高的高度。

再來，將 **最高水高=MIN(left高度, right高度)**，並將 **最大水量=MAX(最大水量, 最高水高\*(right-left))**。

直到left和right交會，最大水量就是答案了。

方法很簡單，但重點是 **為什麼這樣會是對的?**

我們來假設一種情況，如果一開始圖長這樣

![](https://i.imgur.com/1Bm5UWo.jpg)

圖中的兩條紅線是左右找到的第一對，藍色區塊是水量。

![](https://i.imgur.com/Uz1UXDw.jpg)

接著左右繼續向內又找到第二對(橘色線)，那麼此時橘色線圍出的水量(綠色區塊)是不是有機會大於原本的最大水量(藍色區塊)了?

![](https://i.imgur.com/YyhYTfd.jpg)

那麼我們假設綠色區塊大於藍色區塊的情況，綠色區塊就成為新的最大水量了。同時橘色線也成為新的最高高度。

![](https://i.imgur.com/Lnajmjp.jpg)

再繼續向內，又找到了第三對(橘色線)，橘色線圍出的水量是綠色區塊，**但你想，此時綠色區塊有機會大於藍色區塊嗎?**

![](https://i.imgur.com/RTbQ2aj.jpg)

**答案是: 不可能的。** 因為綠色寬度就肯定是輸藍色了，現在連高度都輸，這樣子憑甚麼跟藍色比!?

這下得到一個結論，**靠近內側的高度一定要大於靠近外側的高度，才有機會贏過外側。**

這結論就是為什麼演算法第一行是這樣設計:

> 首先，left從頭開始，right從尾端開始，從兩側向內夾擊，**直到左右各找到一對大於目前水高的高度**。

## 結果
> 06/06/2021 13:32	Accepted	1 ms	52.4 MB	java  
> 時間:100% / 空間:85.02%

一些小發現:
* 如果長度不用變數存起來，速度變慢，記憶體也變多。
* 如果加註解，記憶體會稍微多一些。

## Discuss
Here is my code:
```
public int maxArea(int[] height) {
	int n = height.length, left = 0, right = n-1, maxHeight = 0, maxWater = 0;
	// scan array from the both side
	// if right and left are cross, then end scaning
	while(left < right) {
		while(height[left] <= maxHeight && left != n-1) left++;	// find left limit
		while(height[right] <= maxHeight && right != 0) right--;	// find right limit
		maxHeight = Math.min(height[left], height[right]);	// maxHeight is the smaller one
		maxWater = Math.max(maxWater, maxHeight*(right-left));	// maxHeight*(right-left) is the new capacity
	}

	return maxWater;	// return answer
}
```
Why faster?
* You only have to update max water when left and right are both larger than max height.
* Use `n = height.length` to faster your code and reduce memory.
