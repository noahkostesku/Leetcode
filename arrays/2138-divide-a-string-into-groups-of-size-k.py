class Solution:
    def divideString(self, s: str, k: int, fill: str) -> List[str]:
        
        result = []

        for i in range(0, len(s), k):
            current_sub = s[i:i+k]
            if len(current_sub) < k:
                current_sub += fill * (k - len(current_sub))
            result.append(current_sub)

        return result
