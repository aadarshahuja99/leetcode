class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        // kahn's algorithm's slight modification
        Queue<int[]> q = new LinkedList<>();
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
                q.add(new int[] { time[i], i });
            }
        }
        int[] starts = new int[n];
        int ans = 0;
        while(q.size() > 0)
        {
            int[] top = q.poll();
            int endTime = top[0];
            ans = Math.max(ans, endTime);
            for(int node : adjList.get(top[1]))
            {
                indegree[node]--;
                starts[node] = Math.max(starts[node], endTime);
                if(indegree[node] == 0)
                {
                    q.add(new int[] { time[node]+starts[node], node });
                }
            }
        }
        return ans;
    }
}