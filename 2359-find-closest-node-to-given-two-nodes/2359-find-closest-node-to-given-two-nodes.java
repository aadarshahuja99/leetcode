class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        LinkedList<QueueElement> pq = new LinkedList<QueueElement>();
        int[] distances1 = new int[edges.length];
        int[] distances2 = new int[edges.length];
        Arrays.fill(distances1,Integer.MAX_VALUE);
        Arrays.fill(distances2,Integer.MAX_VALUE);
        distances1[node1] = 0;
        pq.addLast(new QueueElement(0,node1));
        while(pq.size() > 0)
        {
            var top = pq.removeFirst();
            int dist = top.getDistance();
            int nodeVal = top.getCurrent();
            if(edges[nodeVal] != -1 && distances1[edges[nodeVal]] > dist + 1)
            {
                distances1[edges[nodeVal]] = dist + 1;
                pq.addLast(new QueueElement(distances1[edges[nodeVal]],edges[nodeVal]));
            }
        }
        distances2[node2] = 0;
        pq.addLast(new QueueElement(0,node2));
        while(pq.size() > 0)
        {
            var top = pq.removeFirst();
            int dist = top.getDistance();
            int nodeVal = top.getCurrent();
            if(edges[nodeVal] != -1 && distances2[edges[nodeVal]] > dist + 1)
            {
                distances2[edges[nodeVal]] = dist + 1;
                pq.addLast(new QueueElement(distances2[edges[nodeVal]],edges[nodeVal]));
            }
        }
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0; i<edges.length; i++)
        {
            // System.out.println(" for " + i + " d1: " + distances1[i] + " d2: " + distances2[i]);
            if(distances1[i] == Integer.MAX_VALUE || distances2[i] == Integer.MAX_VALUE)
            {
                continue;
            }
            int score = Math.max(distances1[i],distances2[i]);
            if(score < min)
            {
                min = score;
                idx = i;
            }
        }
        return idx;
    }
    class QueueElement
    {
        private int distance;
        private int current;
        public QueueElement(int d, int c)
        {
            distance = d;
            current = c;
        }
        public int getDistance()
        {
            return distance;
        }
        public int getCurrent()
        {
            return current;
        }
    }
}