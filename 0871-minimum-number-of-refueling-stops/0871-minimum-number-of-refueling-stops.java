class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> {
            return b-a;
        });
        long dist = startFuel;
        int res = 0;
        int idx = 0;
        while (true) {
            while (idx < stations.length && stations[idx][0] <= dist) {
                queue.offer(stations[idx][1]); // for the current level, choose the station that can give the most fuel
                idx++;
            }
            
            if (dist >= target) return res;
            if (queue.isEmpty()) return -1;
            dist += queue.poll();
            res++;
        }
    }
}