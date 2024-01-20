class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<QueueElement>> adjList = new ArrayList<ArrayList<QueueElement>>();
        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<QueueElement>());
        }
        int idx = 0;
        for(int[] edge : edges)
        {
            adjList.get(edge[0]).add(new QueueElement(edge[1],succProb[idx]));
            adjList.get(edge[1]).add(new QueueElement(edge[0],succProb[idx]));
            idx++;
        }
        PriorityQueue<QueueElement> pq = new PriorityQueue<QueueElement>(new Comparator<QueueElement>() {
            public int compare(QueueElement q1, QueueElement q2)
            {
                return Double.compare(q2.getProb(),q1.getProb());
            }
        });
        pq.add(new QueueElement(start_node,1.0));
        double[] probabilities = new double[n];
        probabilities[start_node]=1.0;
        while(pq.size() > 0)
        {
            var top = pq.poll();
            int current = top.getNode();
            double prob = top.getProb();
            for(QueueElement node : adjList.get(current))
            {
                if(probabilities[node.getNode()] < prob*node.getProb())
                {
                    probabilities[node.getNode()] = prob*node.getProb();
                    pq.add(new QueueElement(node.getNode(),probabilities[node.getNode()]));
                }
            }
        }
        return probabilities[end_node];
    }
    class QueueElement
    {
        private double prob;
        private int node;
        public QueueElement(int n, double p)
        {
            node=n;
            prob=p;
        }
        public int getNode()
        {
            return node;
        }
        public double getProb()
        {
            return prob;
        }
    }
}