class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:

        conv_min = []

        for time in timePoints:
            hour = int(time[:2])
            minute = int(time[3:])
            conv_min.append(hour*60 + minute)

        conv_min.sort()


        min_diff = 24 * 60

        for current, next in zip(conv_min, conv_min[1:]):
            min_diff = min(min_diff, next- current)

        wrap_around = (conv_min[0] + 24 * 60) - conv_min[-1]
        min_diff = min(min_diff, wrap_around)

        return min_diff
