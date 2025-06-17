class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split()
        if len(pattern) != len(words):
            return False

        pattern_dict = {}
        word_set = set()

        for char, word in zip(pattern, words):
            if char in pattern_dict:
                if pattern_dict[char] != word:
                    return False
            else:
                if word in word_set:
                    return False
                pattern_dict[char] = word
                word_set.add(word)

        return True

