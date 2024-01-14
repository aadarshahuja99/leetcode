class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        if(n==1)
        {
            return 0;
        }
        ArrayList<ArrayList<QueueElement>> adjList = new ArrayList<ArrayList<QueueElement>>();
        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<QueueElement>());
        }
        for(int i=0; i<times.length; i++)
        {
            adjList.get(times[i][0]-1).add(new QueueElement(times[i][1]-1,times[i][2]));
        }
        PriorityQueue<QueueElement> pq = new PriorityQueue<QueueElement>(new Comparator<QueueElement>() {
    public int compare(QueueElement n1, QueueElement n2) {
        return n1.getDistance() - n2.getDistance();
    }
});
        int[] distances = new int[n];
        Arrays.fill(distances,Integer.MAX_VALUE);
        distances[k-1] = 0;
        pq.add(new QueueElement(k-1,0));
        while(pq.size() > 0)
        {
            QueueElement top = pq.poll();
            int index = top.getIndex();
            int dist = top.getDistance();
            for(QueueElement node : adjList.get(index))
            {
                if(distances[node.getIndex()] > dist + node.getDistance())
                {
                    distances[node.getIndex()] = dist+node.getDistance();
                    pq.add(new QueueElement(node.getIndex(),distances[node.getIndex()]));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<distances.length; i++)
        {
            if(distances[i] == Integer.MAX_VALUE)
            {
                return -1;
            }
            max = Math.max(max,distances[i]);
        }
        return max;
    }
    class QueueElement
    {
        private int index;
        private int dist;
        public QueueElement(int i, int d)
        {
            index = i;
            dist = d;
        }
        public void setDistance(int d)
        {
            dist = d;
        }
        public int getDistance()
        {
            return dist;
        }
        public int getIndex()
        {
            return index;
        }
    }
}