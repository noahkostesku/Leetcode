class Solution:
    def dayOfYear(self, date: str) -> int:
        year = int(date[:4])
        month = int(date[5:7])
        day = int(date[8:])

        is_leap = (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0)

        month_days = {
            1: 31, 2: 29 if is_leap else 28, 3: 31, 4: 30,
            5: 31, 6: 30, 7: 31, 8: 31,
            9: 30, 10: 31, 11: 30, 12: 31
        }

        day_of_year = sum(month_days[m] for m in range(1, month)) + day
        return day_of_year
