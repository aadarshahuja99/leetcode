class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adj = new int[n][n];
        for(int[] row : adj)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for(int[] e : edges)
        {
            adj[e[0]][e[1]] = e[2];
            adj[e[1]][e[0]] = e[2];
        }
        for(int i=0; i<n; i++) adj[i][i] = 0;
        for(int k=0; k<n; k++)
        {
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    if(adj[i][k] == Integer.MAX_VALUE || adj[k][j] == Integer.MAX_VALUE)
                    {
                        continue;
                    }
                    adj[i][j] = Math.min(adj[i][k] + adj[k][j], adj[i][j]);
                }
            }
        }
        int min = n+1;
        int ans = -1;
        for(int i=0; i<n; i++)
        {
            int count = 0;
            for(int j=0; j<n; j++)
            {
                if(adj[i][j] <= distanceThreshold) count++;
            }
            if(min > count)
            {
                min = count;
                ans = i;
            }
            else if(min == count)
            {
                ans = i;
            }
        }
        return ans;
    }
}