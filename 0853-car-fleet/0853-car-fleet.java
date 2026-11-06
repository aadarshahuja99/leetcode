class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        
        // Sort by starting position in descending order (closest to target first)
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        
        int fleets = 0;
        double maxTime = 0.0;
        
        for (int i = 0; i < n; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];
            // If this car takes MORE time than the fleet ahead of it,
            // it can never catch up. It starts a new fleet.
            if (time > maxTime) {
                fleets++;
                maxTime = time; 
            }
        }
        
        return fleets;
    }
}
