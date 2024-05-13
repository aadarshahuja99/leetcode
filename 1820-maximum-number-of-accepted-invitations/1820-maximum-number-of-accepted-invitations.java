class Solution {
    public int maximumInvitations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] mapping = new int[n];
        Arrays.fill(mapping, -1);
        int ans = 0;
        for(int i=0; i<m; i++)
        {
            boolean[] visited = new boolean[n];
            if(findMaxMatching(i, grid, visited, mapping))
            {
                ans++;
            }
        }
        return ans;
    }
    private boolean findMaxMatching(int current, int[][] grid, boolean[] visited, int[] mapping)
    {
        int n = grid[0].length;   
        for(int i=0; i<n; i++)
        {
            if(grid[current][i] == 1 && !visited[i])
            {
                visited[i] = true;
                if(mapping[i] < 0 || findMaxMatching(mapping[i], grid, visited, mapping))
                {
                    mapping[i] = current;
                    return true;
                }
            }
        }
        return false;
    }
}