class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<List<double[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }
        int idx = 0;
        for(int[] e : edges)
        {
            adj.get(e[0]).add(new double[] { e[1], succProb[idx] });
            adj.get(e[1]).add(new double[] { e[0], succProb[idx] });
            idx++;
        }
        boolean[] vis = new boolean[n];
        double[] prob = new double[n];
        Arrays.fill(prob, Double.MIN_VALUE);
        // max-heap
        PriorityQueue<double[]> q = new PriorityQueue<>((a,b) -> {
            return Double.compare(b[1],a[1]);
        });
        q.add(new double[] { start, 1.0 });
        prob[start] = 1.0;
        while(q.size() > 0)
        {
            var top = q.poll();
            int node = (int)top[0];
            double probability = top[1];
            if(vis[node])
            {
                continue;
            }
            vis[node] = true;
            if(node == end)
            {
                return probability;
            }
            for(double[] ed : adj.get(node))
            {
                double newProbability = probability*ed[1];
                if(newProbability > prob[(int)ed[0]])
                {
                    prob[(int)ed[0]] = newProbability;
                    q.add(new double[] { ed[0], newProbability });
                }
            }
        }
        return 0.0;
    }
}