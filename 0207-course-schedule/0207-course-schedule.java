class Solution {
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int[] edge : pre)
        {
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }
        if(q.size() == 0)
        {
            return false;
        }
        int count = 0;
        while(q.size() > 0)
        {
            int top = q.poll();
            count++;
            for(int node : adj.get(top))
            {
                indegree[node]--;
                if(indegree[node] == 0)
                {
                    q.add(node);
                }
            }
        }
        return count == n;
    }
}