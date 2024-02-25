class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        int[] shortest = new int[n];
        int[] second = new int[n];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        Arrays.fill(second, Integer.MAX_VALUE);
        shortest[0] = 0;
        ArrayList<ArrayList<Integer>> adjList= new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[0]-1).add(edge[1]-1);
            adjList.get(edge[1]-1).add(edge[0]-1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return a[1]-b[1];
            }
        });
        pq.add(new int[] { 0, 0 });
        while(pq.size() > 0)
        {
            var top = pq.poll();
            int t = top[1];
            int phase = t/change;
            if(phase%2 == 1)
            {
                t = change*(phase+1);
            }
            for(int node : adjList.get(top[0]))
            {
                if(time+t < shortest[node])
                {
                    second[node] = shortest[node];
                    shortest[node] = time+t;
                    pq.add(new int[] { node, shortest[node] });
                }
                else if(time+t > shortest[node] && time+t < second[node])
                {
                    second[node] = time+t;
                    pq.add(new int[] { node, second[node] });
                }
            }
        }
        return second[n-1];
    }
}