class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        
        nums_visited = set()
        for num in nums:
            nums_visited.add(num)
        
        nums_count = len(nums_visited)

        left, right, res = 0, 0, 0

        while left < len(nums):
            right = left
            curr_set = set()
            while right < len(nums):
                curr_set.add(nums[right])
                if len(curr_set) == nums_count:
                    res += 1
                right += 1
            left += 1
        
        return res

        




