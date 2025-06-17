class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        
        pos_arr, neg_arr = [], []
        for num in nums:
            if num > 0:
                pos_arr.append(1)
            elif num < 0:
                neg_arr.append(1)
            else:
                continue

        return max(sum(pos_arr), sum(neg_arr))
