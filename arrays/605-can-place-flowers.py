# class Solution(object):
#     def canPlaceFlowers(self, flowerbed, n):
        

#         zeros = flowerbed.count(0)

#         if zeros % 2 == 0:
#             if zeros - n > 2:
#                 return True
#         elif zeros % 2 == 1:
#             if zeros - n > 1:
#                 return True
        
#         return False
        
class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        #pad to handle edge case
        flowerbed = [0] + flowerbed + [0]
        count = 0

        for i in range(1, len(flowerbed) - 1):
            #check adjacency
            if flowerbed[i-1] == 0 and flowerbed[i] == 0 and flowerbed[i+1] == 0:
                flowerbed[i] = 1
                count += 1
                if count >= n:
                    return True

        return count >= n
 
