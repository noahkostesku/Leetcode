class Solution(object):
    def maximumSum(self, nums):
        # Map sum of digits to list of indices
        map_ = {}

        for i in range(len(nums)):
            sum_ = 0
            curr_num = nums[i]
            while curr_num != 0:
                sum_ += curr_num % 10
                curr_num //= 10 

            #add in map sum on digits --> number in array
            if sum_ in map_:
                map_[sum_].append(nums[i])
            else:
                map_[sum_] = [nums[i]]

        max_ = -1
        for values in map_.values():
            if len(values) > 1:
                #descending order sort, nums with same sum and the highest 2 nums
                values.sort(reverse=True) 
                #compare curr max with top elems in values list
                max_ = max(max_, values[0] + values[1])  

        return max_


            

            
