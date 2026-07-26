class Solution(object):
    def aggregateTimeSeries(self, series1, series2):
        """
        :type series1: List[List[int]]
        :type series2: List[List[int]]
        :rtype: List[List[int]]
        """
        
        i1 = 0
        i2 = 0
        
        l1 = len(series1)
        l2 = len(series2)
        
        aggregated_series = []
        
        while True:
            if i1 == l1 and i2 == l2:
                break
            elif i1 == l1:
                aggregated_series.append([series2[i2][0], series2[i2][1]])
                i2 += 1
            elif i2 == l2:
                aggregated_series.append([series1[i1][0], series1[i1][1]])
                i1 += 1
            elif series1[i1][0] < series2[i2][0]:
                aggregated_series.append([series1[i1][0], series1[i1][1] + series2[i2][1]])
                i1 += 1
            elif series1[i1][0] == series2[i2][0]:
                aggregated_series.append([series1[i1][0], series1[i1][1] + series2[i2][1]])
                i1 += 1
                i2 += 1
            elif series1[i1][0] > series2[i2][0]:
                aggregated_series.append([series2[i2][0], series1[i1][1] + series2[i2][1]])
                i2 += 1
            
        return aggregated_series
