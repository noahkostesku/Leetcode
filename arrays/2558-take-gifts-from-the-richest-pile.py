import math
import heapq

class Solution(object):
    def pickGifts(self, gifts, k):
        #max heap
        max_heap = [-i for i in gifts]
        heapq.heapify(max_heap)

        for _ in range(k):
            largest = -heapq.heappop(max_heap)  #largest element
            new_value = int(math.sqrt(largest))  #floored square root for integer nums
            heapq.heappush(max_heap, -new_value)  #push back into heap

        return -sum(max_heap)  #cback to positive values


        
