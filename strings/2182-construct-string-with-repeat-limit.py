from collections import Counter

class Solution:
    def repeatLimitedString(self, s: str, repeatLimit: int) -> str:
        
        counter = Counter(s)
        keys = sorted(counter.keys(), reverse=True)
        result = []
        
        index = 0  
        while index < len(keys):
            key = keys[index]
            count = counter[key]
            use = min(count, repeatLimit)
            result.extend([key] * use)
            counter[key] -= use

            if counter[key] == 0:
                index += 1 
            else:
                #using only 1 character after max one to use
                found = False
                for j in range(index+1, len(keys)):
                    if counter[keys[j]] > 0:
                        result.append(keys[j])
                        counter[keys[j]] -= 1
                        found = True
                        break
                if not found:
                    break

        return ''.join(result)
