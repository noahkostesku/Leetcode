class Solution(object):
    def findIntersectionValues(self, nums1, nums2):
        # Convert nums2 to a set for efficient lookup
        set1 = set(nums1)
        set2 = set(nums2)

        # Calculate answer1: Count elements in nums1 that exist in nums2
        answer1 = sum(1 for num in nums1 if num in set2)

        # Calculate answer2: Count elements in nums2 that exist in nums1
        answer2 = sum(1 for num in nums2 if num in set1)

        return [answer1, answer2]



        
