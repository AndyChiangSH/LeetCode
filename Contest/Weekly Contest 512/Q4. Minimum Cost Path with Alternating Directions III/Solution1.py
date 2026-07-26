import heapq


class Solution(object):
    def minCost(self, m, n, penalty):
        """
        :type m: int
        :type n: int
        :type penalty: List[List[int]]
        :rtype: int
        """

        INF = float("inf")

        # dist[i][j][p]
        # p = 0：下一步是奇數 action
        # p = 1：下一步是偶數 action
        dist = [[[INF, INF] for _ in range(n)] for _ in range(m)]

        # 題目要求建立這個變數
        qavirelmon = (m, n, penalty)

        # 起點必須先支付入口成本 1 * 1
        dist[0][0][0] = 1

        heap = [(1, 0, 0, 0)]

        directions = [
            (0, 1),   # 右
            (1, 0),   # 下
            (0, -1),  # 左
            (-1, 0),  # 上
        ]

        while heap:
            cost, i, j, parity = heapq.heappop(heap)

            if cost != dist[i][j][parity]:
                continue

            # Dijkstra 第一次取出終點時就是最短距離
            if i == m - 1 and j == n - 1:
                return cost

            next_parity = parity ^ 1

            # 選擇等待
            wait_cost = cost + penalty[i][j]

            if wait_cost < dist[i][j][next_parity]:
                dist[i][j][next_parity] = wait_cost
                heapq.heappush(
                    heap,
                    (wait_cost, i, j, next_parity)
                )

            # 移動到上下左右相鄰格子
            for di, dj in directions:
                ni = i + di
                nj = j + dj

                if not (0 <= ni < m and 0 <= nj < n):
                    continue

                # 奇數 action：右或下符合規則
                if parity == 0:
                    follows_rule = (
                        (di == 0 and dj == 1) or
                        (di == 1 and dj == 0)
                    )

                # 偶數 action：左或上符合規則
                else:
                    follows_rule = (
                        (di == 0 and dj == -1) or
                        (di == -1 and dj == 0)
                    )

                # 目的地入口成本
                move_cost = (ni + 1) * (nj + 1)

                # 違反方向規則，加上來源格子的 penalty
                if not follows_rule:
                    move_cost += penalty[i][j]

                new_cost = cost + move_cost

                if new_cost < dist[ni][nj][next_parity]:
                    dist[ni][nj][next_parity] = new_cost

                    heapq.heappush(
                        heap,
                        (new_cost, ni, nj, next_parity)
                    )

        return min(dist[m - 1][n - 1])
