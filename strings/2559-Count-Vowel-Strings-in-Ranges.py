class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        vowels = {"a", "e", "i", "o", "u"}

        tags = [int(word[0] in vowels and word[-1] in vowels) for word in words]

        prefix = [0] * (len(words) + 1)
        for i in range(len(words)):
            prefix[i + 1] = prefix[i] + tags[i]

        result = []
        for l, r in queries:
            result.append(prefix[r + 1] - prefix[l])

        return result
