class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        // re-rooting dp on trees
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj1.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++)
        {
            adj2.add(new ArrayList<>());
        }
        for(int[] e : edges1)
        {
            adj1.get(e[0]).add(e[1]);
            adj1.get(e[1]).add(e[0]);
        }
        for(int[] e : edges2)
        {
            adj2.get(e[0]).add(e[1]);
            adj2.get(e[1]).add(e[0]);
        }
        var ans1 = getAns(adj1);
        var ans2 = getAns(adj2);
        int[] ans = new int[n];
        int maxOddIn2 = -1;
        for(int i=0; i<m; i++)
        {
            maxOddIn2 = Math.max(maxOddIn2, ans2[i][1]);
        }
        for(int i=0; i<n; i++){
            ans[i] = ans1[i][0] + maxOddIn2;
        }
        return ans;
    }
    private int[][] getAns(ArrayList<ArrayList<Integer>> adj)
    {
        int n = adj.size();
        int[][] ans = new int[n][2];
        for(int i=0; i<n; i++)
        {
            ans[i][0] = 1;
        }
        dfs(0, -1, adj, ans);
        dfs2(0, -1, adj, ans);
        // for(int i=0; i<n; i++){
        //     System.out.println(ans[i][0]+" "+ans[i][1]);
        // }
        return ans;
    }
    private int[] dfs(int current, int p, ArrayList<ArrayList<Integer>> adj, int[][] ans)
    {
        for(int node : adj.get(current))
        {
            if(node == p)
            {
                continue;
            }
            var nodeStatus = dfs(node, current, adj, ans);
            ans[current][0] += nodeStatus[1];
            ans[current][1] += nodeStatus[0];
        }
        return ans[current];
    }
    private void dfs2(int current, int p, ArrayList<ArrayList<Integer>> adj, int[][] ans)
    {
        for(int node : adj.get(current))
        {
            if(node == p)
            {
                continue;
            }
            ans[node][0] += (ans[current][1] - ans[node][0]);
            ans[node][1] += (ans[current][0] - ans[node][1]);
            dfs2(node, current, adj, ans);
        }
    }
}