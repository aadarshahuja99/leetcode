class Solution {
    public int countPaths(int n, int[][] roads) {
        if(n==1)
        {
            return 1;
        }
        ArrayList<ArrayList<QueueElement>> adjList = new ArrayList<ArrayList<QueueElement>>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<QueueElement>());
        }
        for(int[] road : roads)
        {
            adjList.get(road[0]).add(new QueueElement(road[1],(long)road[2]));
            adjList.get(road[1]).add(new QueueElement(road[0],(long)road[2]));
        }
        int[] paths = new int[n];
        long[] distances = new long[n];
        Arrays.fill(distances,Long.MAX_VALUE);
        distances[0] = 0;
        paths[0] = 1;
        PriorityQueue<QueueElement> pq = new PriorityQueue<QueueElement>(new Comparator<QueueElement>() {
            public int compare(QueueElement q1, QueueElement q2)
            {
                return Long.compare(q1.dist,q2.dist);
            }
        });
        pq.add(new QueueElement(0,0));
        while(pq.size() > 0)
        {
            QueueElement top = pq.poll();
            int index = top.getIndex();
            long dist = top.getDistance();
            for(QueueElement node : adjList.get(index))
            {
                if(distances[node.getIndex()] > dist + node.getDistance())
                {
                    distances[node.getIndex()] = dist + node.getDistance();
                    paths[node.getIndex()] = paths[index];
                    pq.add(new QueueElement(node.getIndex(),distances[node.getIndex()]));
                }
                else if(distances[node.getIndex()] == dist + node.getDistance())
                {
                    paths[node.getIndex()] = ((paths[node.getIndex()])%1000000007 + (paths[index])%1000000007)%1000000007;
                }
            }
        }
        return paths[n-1];
    }
    class QueueElement
    {
        private int index;
        private long dist;
        public QueueElement(int i, long d)
        {
            index = i;
            dist = d;
        }
        public void setDistance(long d)
        {
            dist = d;
        }
        public long getDistance()
        {
            return dist;
        }
        public int getIndex()
        {
            return index;
        }
    }
}