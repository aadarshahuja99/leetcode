public class Solution {
    public int FindJudge(int n, int[][] trust) {
        List<List<int>> adjList = new();
        int[] indegree = new int[n];
        int[] outDegree = new int[n];
        foreach(var edge in trust)
        {
            indegree[edge[1]-1] += 1;
            outDegree[edge[0]-1] += 1;
        }
        for(int i=0; i<n; i++)
        {
            if(indegree[i] == n-1 && outDegree[i] == 0)
            {
                return i+1;
            }
        }
        return -1;
    }
}