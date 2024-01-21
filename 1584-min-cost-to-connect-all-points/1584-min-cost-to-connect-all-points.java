class Solution {
    public int minCostConnectPoints(int[][] points) {
        // Create a MST using Kruskal's algorithm. n*n TC to create edges. Sort all the edges. Then, use a disjoint set to connect edges. total TC: (n*n)log(n*n). Total SC: n*n to store all the edges. Since, this is a dense graph. Use Prim's algo for better performance
        if(points.length == 1)
        {
            return 0;
        }
        int n = points.length;
        PriorityQueue<QueueElement> pq = new PriorityQueue<QueueElement>(new Comparator<QueueElement>() {
            public int compare(QueueElement q1, QueueElement q2)
            {
                return q1.getDistance()-q2.getDistance();
            }
        });
        ArrayList<ArrayList<QueueElement>> adjList = new ArrayList<ArrayList<QueueElement>>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<QueueElement>());
        }
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int d = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                adjList.get(i).add(new QueueElement(j,d));
                adjList.get(j).add(new QueueElement(i,d));
            }
        }
        int[] visited = new int[n];
        pq.add(new QueueElement(0,0));
        int ans = 0;
        while(pq.size() > 0)
        {
            var top = pq.poll();
            int dist = top.getDistance();
            int current = top.getNode();
            if(visited[current] == 1)
            {
                continue;
            }
            ans += dist;
            visited[current] = 1;
            for(QueueElement node : adjList.get(current))
            {
                if(visited[node.getNode()] == 0)
                {
                    pq.add(node);
                }
            }
        }
        return ans;
    }
    class QueueElement
    {
        private int node;
        private int dist;
        public QueueElement(int n, int d)
        {
            node=n;
            dist=d;
        }
        public int getDistance()
        {
            return dist;
        }
        public int getNode()
        {
            return node;
        }
    }
}