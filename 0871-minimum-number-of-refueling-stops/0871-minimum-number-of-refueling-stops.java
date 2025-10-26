class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> {
            return b-a;
        });
        long levelEnd = startFuel;
        int reFuels = 0;
        int idx = 0;
        int n = stations.length;
        while (levelEnd < target) {
            // dist that can be reached so far is less than the target, thus refuelling is required.
            // we greedily choose the station that has already been traversed and can help us get the farthest away from the current level end (i.e dist value)
            while (idx < n && stations[idx][0] <= levelEnd) {
                maxHeap.add(stations[idx][1]);
                idx++;
            }
            if(maxHeap.size() > 0)
            {
                levelEnd += maxHeap.poll(); // for the current level, choose the station that can give the most fuel
            }
            else
            {
                // dist is less than target and we do not have refueling stops
                return -1;
            }
            reFuels++;
        }
        return reFuels;
    }
}