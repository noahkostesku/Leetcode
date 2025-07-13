class Solution:
    def reverseStr(self, s: str, k: int) -> str:

        parsed_s = []
        left = 0
        n = len(s)
        while left < n:
            right = min(left + 2*k, n)
            parsed_s.append(s[left:right])
            left = right

        rev_parsed_strings = []

        for string in parsed_s:
            rev = string[:k][::-1]
            new_str = rev + string[k:]
            rev_parsed_strings.append(new_str)

        result = ""
        
        for string in rev_parsed_strings:
            result += string

        return result
