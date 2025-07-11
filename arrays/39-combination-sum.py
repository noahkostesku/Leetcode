class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def combinations(index: int, current_list: List[int], current_sum: int) -> List[int]:
            if current_sum == target:
                result.append(current_list[:])
                return

            if index == len(candidates) or current_sum > target:
                return

            current_list.append(candidates[index])
            combinations(index, current_list, current_sum + candidates[index])
            current_list.pop()

            combinations(index + 1, current_list, current_sum)


        combinations(0, [], 0)
        return result
