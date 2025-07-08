class Solution:
    def threeConsecutiveOdds(self, arr: List[int]) -> bool:
        
        left, right = 0, 0

        while right < len(arr):
            count = 0

            while right < len(arr) and arr[right] % 2 == 1 and count < 3:
                count += 1
                right += 1

            if count == 3:
                return True

            if count > 0:
                left = right
            else:
                right += 1
                left = right

        return False
