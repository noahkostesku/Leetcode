class Solution:
    def countSymmetricIntegers(self, low: int, high: int) -> int:
        
        left_arr, right_arr = [], []
        result = 0

        for num in range(low, high + 1):
            current_num = str(num)
            if len(current_num) % 2 == 1:
                continue
            
            mid = len(current_num) // 2
            left_arr = [int(ch) for ch in current_num[:mid]]
            right_arr = [int(ch) for ch in current_num[mid:]]

            if sum(left_arr) == sum(right_arr):
                result += 1

        return result
