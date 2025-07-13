from collections import Counter

class Solution:
    def checkRecord(self, s: str) -> bool:

        absent = Counter(s)
        if absent['A'] > 1:
            return False

        late_builder = 0
        for char in s:
            if char == 'L':
                late_builder += 1
                if late_builder >= 3:
                    return False
            else:
                late_builder = 0

        return True

