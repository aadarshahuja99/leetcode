class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int n = patience.length;
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] times = new int[n];
        Queue<int[]> queue = new LinkedList<>();
        Arrays.fill(times,Integer.MAX_VALUE);
        queue.add(new int[] { 0,0 });
        times[0] = 0;
        while(queue.size() > 0)
        {
            var top = queue.poll();
            int time = top[1];
            int topNode = top[0];
            for(int node : adjList.get(topNode))
            {
                if(times[node] != Integer.MAX_VALUE)
                {
                    continue;
                }
                times[node] = time+1;
                queue.add(new int[] { node, times[node] });
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=1; i<n; i++)
        {
            int numResends = 2*times[i]/patience[i];
            if((2*times[i])%patience[i] == 0)
            {
                numResends -= 1;
            }
            int lastResendTime = numResends*patience[i];
            int lastReplyTime = 2*times[i] + lastResendTime;
            // System.out.println(lastReplyTime+" "+i);
            ans = Math.max(ans, lastReplyTime);
        }
        return ans+1;
    }
}