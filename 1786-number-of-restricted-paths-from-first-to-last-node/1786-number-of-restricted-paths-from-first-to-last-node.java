class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        PriorityQueue<QueueElement> pq = new PriorityQueue<QueueElement>(new Comparator<QueueElement>() 
        {
            public int compare(QueueElement q1, QueueElement q2)
            {
                return q1.getDistance()-q2.getDistance();
            }
        });
        int[] distances = new int[n+1];
        ArrayList<ArrayList<QueueElement>> adjList = new ArrayList<ArrayList<QueueElement>>();
        for(int i=0; i<=n; i++)
        {
            adjList.add(new ArrayList<QueueElement>());
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[0]).add(new QueueElement(edge[1],edge[2]));
            adjList.get(edge[1]).add(new QueueElement(edge[0],edge[2]));
        }
        Arrays.fill(distances,Integer.MAX_VALUE);
        distances[n] = 0;
        pq.add(new QueueElement(n,0));
        while(pq.size() > 0)
        {
            var top = pq.poll();
            int current = top.getNode();
            int dist = top.getDistance();
            for(QueueElement node : adjList.get(current))
            {
                if(dist + node.getDistance() < distances[node.getNode()])
                {
                    distances[node.getNode()] = dist + node.getDistance();
                    pq.add(new QueueElement(node.getNode(),distances[node.getNode()]));
                }
            }
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(n,adjList,distances,dp);
    }
    private int dfs(int current, ArrayList<ArrayList<QueueElement>> adjList, int[] distances, int[] dp)
    {
        if(current == 1)
        {
            return 1;
        }
        if(dp[current] != -1)
        {
            return dp[current];
        }
        int ans = 0;
        for(QueueElement node : adjList.get(current))
        {
            if(distances[node.getNode()] > distances[current])
            {
                // System.out.println("calling "+node.getNode()+" from "+current);
                ans = (ans + dfs(node.getNode(),adjList,distances,dp))%1000000007;
            }
        }
        dp[current] = ans;
        return ans;
    }
    class QueueElement
    {
        private int node;
        private int distance;
        public QueueElement(int n, int d)
        {
            node=n;
            distance=d;
        }
        public int getNode()
        {
            return node;
        }
        public int getDistance()
        {
            return distance;
        }
    }
}