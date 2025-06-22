class Solution:
    def getLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:

        result = []
        word_arr = list(zip(words, groups))
        result.append(word_arr[0][0])       
        next_binary = 1 - word_arr[0][1]     

        for word, group in word_arr[1:]:
            if group != next_binary:
                continue

            result.append(word)
            next_binary = 1 - next_binary 

        return result
