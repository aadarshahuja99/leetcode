class Solution {
    public int findChampion(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for(int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            indeg[edge[1]]++;
        }
        int ans = -1;
        for(int i=0; i<n; i++)
        {
            if(indeg[i] == 0)
            {
                if(ans != -1)
                {
                    return -1;
                }
                ans = i;
            }
        }
        return ans;
    }
}