class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[n];
        
        // NEW: Track the absolute best distance found so far for each node
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        
        pq.add(new int[]{0, 0});
        minDist[0] = 0; // Distance to start node is 0
        
        int ans = 0;
        int edgesConnected = 0;
        
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int currNode = top[0];
            int edgeWeight = top[1];
            
            if (visited[currNode]) continue;
            
            visited[currNode] = true;
            ans += edgeWeight;
            edgesConnected++;
            
            if (edgesConnected == n) break;
            
            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (!visited[nextNode]) {
                    int dist = Math.abs(points[currNode][0] - points[nextNode][0]) 
                             + Math.abs(points[currNode][1] - points[nextNode][1]);
                    
                    // NEW CONDITION: Only push to the heap if this new edge 
                    // is strictly better than any edge previously found for nextNode
                    if (dist < minDist[nextNode]) {
                        minDist[nextNode] = dist; // Update best-known distance
                        pq.add(new int[]{nextNode, dist}); 
                    }
                }
            }
        }
        
        return ans;
    }
}