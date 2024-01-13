public class Solution {
    public int FindCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.Length];
        int count = 0;
        for(int i=0; i<isConnected.Length; i++)
        {
            if(visited[i] == 0)
            {
                count++;
                dfs(i,isConnected,visited);
            }
        }
        return count;
    }
    private void dfs(int current, int[][] isConnected, int[] visited)
    {
        visited[current] = 1;
        for(int i=0; i<isConnected[0].Length; i++)
        {
            if(visited[i] == 0 && isConnected[current][i] == 1)
            {
                dfs(i,isConnected,visited);
            }
        }
    }
}