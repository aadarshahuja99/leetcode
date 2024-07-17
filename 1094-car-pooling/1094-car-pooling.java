class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // simple range sum problem
        int[] numberOfPassengers = new int[1001];
        for(int i=0; i<trips.length; i++)
        {
            numberOfPassengers[trips[i][1]] += trips[i][0];
            numberOfPassengers[trips[i][2]] -= trips[i][0];
        }
        int currentSum = 0;
        for(int i=0; i<=1000; i++)
        {
            currentSum += numberOfPassengers[i];
            if(currentSum > capacity)
            {
                return false;
            }
        }
        return true;
    }
}