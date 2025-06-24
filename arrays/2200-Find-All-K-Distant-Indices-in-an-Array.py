class Solution:
    def findKDistantIndices(self, nums: List[int], key: int, k: int) -> List[int]:

        marked = [False] * len(nums)

        for i, val in enumerate(nums):
            if val == key:
                left = max(0, i - k)
                right = min(len(nums) - 1, i + k)
                for j in range(left, right + 1):
                    marked[j] = True

        #return indices where marked true
        return [i for i, is_marked in enumerate(marked) if is_marked]
