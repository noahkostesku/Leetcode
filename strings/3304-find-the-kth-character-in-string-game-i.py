class Solution:
    def kthCharacter(self, k: int) -> str:
        word = "a"
        while len(word) < k:
            transformed_word = ''
            for c in word:
                if c == 'z':
                    transformed_word += 'a'
                else:
                    transformed_word += chr(ord(c) + 1)
            word += transformed_word
        return word[k - 1]
