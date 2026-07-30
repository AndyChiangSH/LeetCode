from collections import Counter
import heapq


class Solution(object):
    def minimumPushes(self, word):
        """
        :type word: str
        :rtype: int
        """
        
        # Frequency map to store count of each letter
        frequency_map = Counter(word)

        # Priority queue to store frequencies in descending order
        frequency_queue = [-freq for freq in frequency_map.values()]
        heapq.heapify(frequency_queue)

        total_pushes = 0
        index = 0

        # Calculate total number of presses
        while frequency_queue:
            total_pushes += (1 + (index // 8)) * (
                -heapq.heappop(frequency_queue)
            )
            index += 1
            
        return total_pushes


# Accepted
# 877 / 877 testcases passed
