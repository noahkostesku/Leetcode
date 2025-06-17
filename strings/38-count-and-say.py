class Solution:
    def countAndSay(self, n: int) -> str:

        result = "1"

        i = 2
        while i <= n:
            #create concatination per value up top n
            current = ""
            count = 1
            prev_char = result[0]

            #Loop through the previous sequence
            for j in range(1, len(result)):
                if result[j] == prev_char:
                    count += 1
                else:
                    current += str(count) + prev_char
                    count = 1
                    prev_char = result[j]
            current += str(count) + prev_char
            result = current  
            i += 1

        return result
