class Solution(object):
    def candy(self, ratings):
        sum_array = [1 for _ in range(len(ratings))]  # Initialize with 1 candy per child

        # First pass: left-to-right
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i - 1]:
                sum_array[i] = sum_array[i - 1] + 1

        # Second pass: right-to-left
        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                sum_array[i] = max(sum_array[i], sum_array[i + 1] + 1)

        return sum(sum_array)
