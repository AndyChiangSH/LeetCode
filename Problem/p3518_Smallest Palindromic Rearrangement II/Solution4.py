class Solution(object):
    def smallestPalindrome(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """

        mid = len(s) // 2
        mid_s = s[mid]
        left_s = s[:mid]
        count = [0] * 26
        factorial = [1] * (mid + 1)

        for c in left_s:
            count[ord(c) - 97] += 1

        for i in range(1, (mid + 1)):
            factorial[i] = factorial[i - 1] * i

        # 左半邊的不同排列總數
        n = factorial[mid]

        for i in range(26):
            if count[i] == 0:
                continue

            n //= factorial[count[i]]

        if k > n:
            return ""

        left_a = []

        while mid > 0:
            for i in range(26):
                if count[i] == 0:
                    continue

                # 假設目前位置放第 i 個字母
                # 不需要真的先 count[i] -= 1 再重新計算
                next_n = n * count[i] // mid

                if k > next_n:
                    # 跳過所有以這個字母開頭的排列
                    k -= next_n
                    continue
                else:
                    # 第 k 個排列位於這個字母的區間
                    left_a.append(chr(i + 97))
                    count[i] -= 1
                    mid -= 1
                    n = next_n
                    break

        left_a = "".join(left_a)

        if len(s) % 2 == 0:
            return left_a + left_a[::-1]
        else:
            return left_a + mid_s + left_a[::-1]


# Accepted
# 812 / 812 testcases passed
