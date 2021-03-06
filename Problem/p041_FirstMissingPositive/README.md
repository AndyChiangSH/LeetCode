# p041_First Missing Positive

###### tags: `LeetCode` `Hard`

## 題目
[原題目連結](https://leetcode.com/problems/first-missing-positive/)

給定一個未排序的整數陣列nums，nums中有正數也有負數，請你求出**缺少的最小正整數**(之後都命名為X)。

**演算法的時間複雜度必須在O(N)底下，空間複雜度必須是O(1)。**

## 解題
如果是單純找缺少的最小正整數那沒什麼，但加上複雜度限制後就有點困難了。

### 暴力HashSet解
> Solution1

先將所有出現的正整數放入HashSet，然後從1開始向後檢查哪個整沒出現就行了。

放入HashSet是O(N)，檢查也是O(N)，所以整體時間複雜度是**O(2N)**。  
時間上沒問題，但空間上因為用了HahsSet，並不符合O(1)的規定。

### 如何讓空間複雜度為O(1)?
空間複雜度要為O(1)，換句話說就是不能使用額外空間，也就是必須在原來的陣列完成標記那些正整數曾經出現過，那麼問題來了，**該怎麼在不影響原來陣列值的情況下，完成標記呢?**

在講怎麼標記之前，我們先來觀察這題。  
觀察後就會發現，一個陣列 `nums[1, n]`，n是陣列長度，其實X只有兩種情況：

1. X不在`[1, n]`範圍內, X = n+1。
2. X在`[1, n]`範圍內。

第一種情況，如果X不在`[1, n]`範圍內，則陣列一定要長這樣:`[1, 2, ..., n]` 中間沒有間斷，加上陣列的長度是n，**所以X一定是n+1**。

只要不是第一種情況，就會是第二種情況，**X在`[1, n]`範圍內**。

**綜合以上兩點，我們得到一個結論，X只會在`[1, n]`範圍或者n+1。**

因此驗算法會這樣設計：
1. 我們只需要關注在`[1, n]`範圍內的數字就好。
2. 將這些數字用某種不改變原來值的方法做標記。
3. 從1開始向後檢查，第一個沒標記的數字即為X。

下面就來介紹兩個標記的方法：

### 交換法
比方說讀到第i個，如果`nums[i]`在範圍內，且以`nums[i]`為index對應到的值不等於`nums[i]`自己，則兩兩交換。否則讀下一個。

跑起來長這樣：
```
int[] nums = {-1, 0, 1, 7, 3, -2, 4};

i = 0
-1 0 1 7 3 -2 4 
i = 1
-1 0 1 7 3 -2 4 
i = 2
-1 0 1 7 3 -2 4 
i = 2
1 0 -1 7 3 -2 4 
i = 3
1 0 -1 7 3 -2 4 
i = 3
1 0 -1 4 3 -2 7 
i = 4
1 0 -1 4 3 -2 7 
i = 4
1 0 3 4 -1 -2 7 
i = 5
1 0 3 4 -1 -2 7 
i = 6
1 0 3 4 -1 -2 7 

final：
1 0 3 4 -1 -2 7 
X = 2
```

上面例子就可以很清楚看出，範圍內的數字會和直接和對應index的值做交換，所以有出現的正整數會從1開始，按照index做排序，**而沒出現的正整數因為沒有經過交換，所以對應index的值就不等於該正整數**，該數字就是X。

### 負數法
比方說讀到第i個，如果`nums[i]`在範圍內，將以`nums[i]`為index對應到的值加上負數。否則設為n+1。

跑起來長這樣：
```
int[] nums = {-1, 0, 1, 7, 3, -2, 4};

set out of range value to n+1
i = 0
-1 0 1 7 3 -2 4 
i = 1
8 0 1 7 3 -2 4 
i = 2
8 8 1 7 3 -2 4 
i = 3
8 8 1 7 3 -2 4 
i = 4
8 8 1 7 3 -2 4 
i = 5
8 8 1 7 3 -2 4 
i = 6
8 8 1 7 3 8 4 
-------------
set negative
i = 0
8 8 1 7 3 8 4 
i = 1
8 8 1 7 3 8 4 
i = 2
8 8 1 7 3 8 4 
i = 3
-8 8 1 7 3 8 4 
i = 4
-8 8 1 7 3 8 -4 
i = 5
-8 8 -1 7 3 8 -4 
i = 6
-8 8 -1 7 3 8 -4 
-------------
final：
-8 8 -1 -7 3 8 -4 
X = 2
```

看的出來第一次時，將所有超出範圍的數字都改成n+1(8)，是為了防止負數產生的錯誤，改成n+1也沒關係，因為這些數字本來就不是我們在意的。

第二次時，將存在的正整數視為index的位置加上負號，如此一來，只要是存在的正整數都是負的，改成負的只是差一個負號，並不影響數值，只要用絕對值取值就好!

最後，只要檢查到第一個非負數的數字就是X囉~

這兩個方法的複雜度都是**O(2N)**。

其實像這種標記但不改變原來的數值的情況還滿常見的，把這兩個方法學起來吧!

## 結果
> HashSet  
> 07/09/2021 14:27	Accepted	77 ms	172.1 MB	java  

> 交換法  
> 07/09/2021 15:48	Accepted	1 ms	101.1 MB	java  
> 時間：98.78% / 空間：14.63%

> 負數法
> 07/09/2021 20:16	Accepted	3 ms	96.2 MB	java  
> 時間：52.88% / 空間：18.07%