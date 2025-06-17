class Solution(object):
    def removeDigit(self, number, digit):
        remove = 0
        for i in range(len(number)):
            if number[i] == digit:
                if i != len(number) - 1 and number[i] < number[i+1]:
                    return number[:i] + number[i+1:]
                remove = i
        return number[:remove] + number[remove+1:] 


        
        


        
