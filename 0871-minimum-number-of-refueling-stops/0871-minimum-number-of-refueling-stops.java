class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> {
            return b-a;
        });
        long dist = startFuel;
        int res = 0;
        int idx = 0;
        int n = stations.length;
        while (true) {
            if(dist >= target)
            {
                return res;
            }
            // dist that can be reached so far is less than the target, thus refuelling is required.
            // we greedily choose the station that has already been traversed and can help us get the farthest away from the current level end (i.e dist value)
            while (idx < n && stations[idx][0] <= dist) {
                queue.add(stations[idx][1]);
                idx++;
            }
            if(queue.size() > 0)
            {
                dist += queue.poll(); // for the current level, choose the station that can give the most fuel
            }
            else
            {
                // dist is less than target and we do not have refueling stops
                return -1;
            }
            res++;
        }
    }
}