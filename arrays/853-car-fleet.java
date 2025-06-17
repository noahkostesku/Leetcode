import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Double> timeMap = new HashMap<>();

        // Populate timeMap with positions and corresponding times to reach target
        for (int i = 0; i < position.length; i++) {
            double time = (double) (target - position[i]) / speed[i];
            timeMap.put(position[i], time);
        }

        // Sort positions in descending order
        Arrays.sort(position);

        // Initialize variables
        double prevTime = -1.0;
        int fleetCount = 0;

        // Calculate fleets
        for (int i = position.length - 1; i >= 0; i--) {
            double currentTime = timeMap.get(position[i]);

            if (currentTime > prevTime) {
                prevTime = currentTime;
                fleetCount++;
            }
        }

        return fleetCount;
    }
}




