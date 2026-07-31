import math


class Solution(object):
    def smallestPalindrome(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """

        half_length = len(s) // 2
        count = [0] * 26

        # 因為 s 本身是回文，只需要統計左半邊
        for c in s[:half_length]:
            count[ord(c) - ord("a")] += 1

        # 計算左半邊總共有多少種不同排列
        ways = math.factorial(half_length)

        for frequency in count:
            ways //= math.factorial(frequency)

        if k > ways:
            return ""

        answer = []
        remaining = half_length

        while remaining > 0:
            for i in range(26):
                if count[i] == 0:
                    continue

                # 假設這個位置選擇第 i 個字母
                next_ways = ways * count[i] // remaining

                if k > next_ways:
                    # 跳過所有以此字母開頭的排列
                    k -= next_ways
                else:
                    # 第 k 個排列位於這個字母的區間
                    answer.append(chr(i + ord("a")))
                    count[i] -= 1
                    ways = next_ways
                    remaining -= 1
                    break

        left = "".join(answer)

        if len(s) % 2 == 1:
            middle = s[len(s) // 2]
            return left + middle + left[::-1]

        return left + left[::-1]


# Accepted
# 812 / 812 testcases passed
