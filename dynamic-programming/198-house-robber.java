class Solution {
    public int rob(int[] houseValues) {
        int maxTwoHousesAgo = 0;
        int maxPreviousHouse = 0;

        for (int currentHouseValue : houseValues) {
            int currentMax = Math.max(currentHouseValue + maxTwoHousesAgo, maxPreviousHouse);
            maxTwoHousesAgo = maxPreviousHouse;
            maxPreviousHouse = currentMax;
        }
        return maxPreviousHouse;
    }
}

