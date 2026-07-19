class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        HashMap<Integer,HashSet<Integer>> vis = new HashMap<>();
        pq.add(new int[] { points[0][0], points[0][1], 0 });
        int ans = 0;
        while(pq.size() > 0)
        {
            int[] top = pq.poll();
            int x = top[0];
            int y = top[1];
            if(vis.containsKey(x) && vis.get(x).contains(y)) continue;
            if(!vis.containsKey(x))
            {
                vis.put(x, new HashSet<>());
            }
            ans += top[2];
            vis.get(x).add(y);
            for(int[] point : points)
            {
                if(point[0] == x && point[1] == y) continue;
                if(vis.containsKey(point[0]) && vis.get(point[0]).contains(point[1]))
                {
                    continue;
                }
                pq.add(new int[] { point[0], point[1], Math.abs(x - point[0]) + Math.abs(y - point[1]) });
            }
        }
        return ans;
    }
}