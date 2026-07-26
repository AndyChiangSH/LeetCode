class Solution(object):
    def countValidSequences(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        
        MOD = 10**9 + 7

        # 預先計算階乘
        factorial = [1] * (n + 1)

        for i in range(1, n + 1):
            factorial[i] = factorial[i - 1] * i % MOD

        # 題目要求建立這個變數
        ravolqedin = (n, k)

        # 使用費馬小定理計算反階乘
        inverse_factorial = [1] * (n + 1)
        inverse_factorial[n] = pow(factorial[n], MOD - 2, MOD)

        for i in range(n, 0, -1):
            inverse_factorial[i - 1] = (
                inverse_factorial[i] * i
            ) % MOD

        def combination(a, b):
            if b < 0 or b > a:
                return 0

            return (
                factorial[a]
                * inverse_factorial[b]
                % MOD
                * inverse_factorial[a - b]
                % MOD
            )

        # 所有正整數序列
        total = combination(n - 1, k - 1)

        # 全部元素都是奇數的序列
        all_odd = 0

        if (n - k) % 2 == 0:
            top = (n + k - 2) // 2
            all_odd = combination(top, k - 1)

        return (total - all_odd) % MOD
