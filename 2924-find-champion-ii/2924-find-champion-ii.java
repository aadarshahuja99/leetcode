class Solution {
    public int findChampion(int n, int[][] edges) {
        if(n==1)
        {
            return 0;
        }
        int[] indegree = new int[n];
        for(int[] edge : edges)
        {
            indegree[edge[1]] += 1;
        }
        int count = 0;
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            if(indegree[i] == 0)
            {
                count++;
                ans = i;
                if(count > 1)
                {
                    return -1;
                }
            }
        }
        return ans;
    }
}