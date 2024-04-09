class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        // kahn's algorithm's slight modification
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return a[0] - b[0];
            }
        });
        int[] indegree = new int[n];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<relations.length; i++)
        {
            adjList.get(relations[i][0]-1).add(relations[i][1]-1);
            indegree[relations[i][1]-1]++;
        }
        for(int i=0; i<n; i++)
        {
            if(indegree[i] == 0)
            {
                pq.add(new int[] { time[i], i });
            }
        }
        int ans = 0;
        while(pq.size() > 0)
        {
            int[] top = pq.poll();
            int endTime = top[0];
            ans = endTime;
            for(int node : adjList.get(top[1]))
            {
                if(indegree[node] == 0)
                {
                    continue;
                }
                indegree[node]--;
                if(indegree[node] == 0)
                {
                    pq.add(new int[] { time[node]+endTime, node });
                }
            }
        }
        return ans;
    }
}