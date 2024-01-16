class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adjMatrix = new int[n][n];
        for(int[] row : adjMatrix)
        {
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==j)
                {
                    adjMatrix[i][j] = 0;
                }
            }
        }
        for(int[] edge : edges)
        {
            adjMatrix[edge[0]][edge[1]] = edge[2];
            adjMatrix[edge[1]][edge[0]] = edge[2];
        }
        for(int k=0; k<n; k++)
        {
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    if(adjMatrix[k][j] != Integer.MAX_VALUE && adjMatrix[i][k] != Integer.MAX_VALUE)
                    {
                        adjMatrix[i][j] = Math.min(adjMatrix[i][k] + adjMatrix[k][j], adjMatrix[i][j]);
                    }
                }
            }
        }
        int[] ans = new int[n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(j==i)
                {
                    continue;
                }
                // System.out.println("i: " + i + "j: " + j + " adjMatrix[i][j]: " + adjMatrix[i][j]);
                if(adjMatrix[i][j] <= distanceThreshold)
                {
                    ans[i] += 1;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int city = -1;
        for(int i=0; i<n; i++)
        {
            // System.out.println("ans[i] for i: " + i + " is  = " + ans[i]);
            if(ans[i] <= min)
            {
                min = ans[i];
                city = i;
            }
        }
        return city;
    }
}