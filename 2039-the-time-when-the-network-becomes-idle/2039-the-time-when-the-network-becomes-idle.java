class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<patience.length; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        LinkedList<QueueElement> q = new LinkedList<QueueElement>();
        q.addLast(new QueueElement(0,0));
        int[] distances = new int[patience.length];
        Arrays.fill(distances,Integer.MAX_VALUE);
        distances[0] = 0;
        while(q.size() > 0)
        {
            QueueElement top = q.removeFirst();
            int index = top.getIndex();
            int distance = top.getDistance();
            for(int node : adjList.get(index))
            {
                if(distance + 1 < distances[node])
                {
                    distances[node] = distance + 1;
                    q.addLast(new QueueElement(node, distances[node]));
                }
            }
        }
        int max = 0;
        for(int i=1; i<distances.length; i++)
        {
            // System.out.println("distance for "  + i + " = " + distances[i]);
            int current = 2*distances[i];
            if(2*distances[i] <= patience[i])
            {
                // do nothing
            }
            else
            {
                if((2*distances[i])%patience[i] == 0)
                {
                    current += (((2*distances[i])/patience[i]) - 1)*patience[i];
                }
                else
                {
                    current += ((2*distances[i])/patience[i])*patience[i];
                }
            }
            max = Math.max(max,current);
            // System.out.println("max after "  + i + " = " + max + " current for i = " + current);
        }
        return max+1;
    }
    class QueueElement
    {
        private int index;
        private int distance;
        public QueueElement(int i, int d)
        {
            index = i;
            distance = d;
        }
        public int getDistance()
        {
            return distance;
        }
        public int getIndex()
        {
            return index;
        }
    }
}