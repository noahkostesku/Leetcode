class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        total = numBottles
        while numBottles >= numExchange:
            new = numBottles // numExchange
            total += new
            numBottles = new + (numBottles % numExchange)
        return total
