class TreeAncestor {
    int[][] sparse_matrix;
    int height;
    public TreeAncestor(int n, int[] parent) {
        height = (int)(Math.ceil(Math.log(n)/Math.log(2)));
        sparse_matrix = new int[n][height+1];
        for(int[] row : sparse_matrix)
        {
            Arrays.fill(row,-1);
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        int idx = 0;
        for(int p : parent)
        {
            if(p==-1)
            {
                idx++;
                continue;
            }
            // System.out.println("at "+p+" "+idx);
            adj.get(p).add(idx);
            idx++;
        }
        int[] visited = new int[n];
        dfs(0,parent,visited,adj);
        // for(int[] row : sparse_matrix)
        // {
        //     System.out.println();
        //     for(int r : row)
        //     {
        //         System.out.print(r+" ");
        //     }
        // }
    }
    private void dfs(int current, int[] parent, int[] visited, ArrayList<ArrayList<Integer>> adj)
    {
        visited[current] = 1;
        sparse_matrix[current][0] = parent[current];
        if(current != 0)
        {
            for(int j=1; j<=height; j++)
            {
                // System.out.println("in loop for "+current+" "+j);
                sparse_matrix[current][j] = sparse_matrix[sparse_matrix[current][j-1]][j-1];
                if(sparse_matrix[current][j] == -1)
                {
                    break;
                }
            }
        }
        for(int node : adj.get(current))
        {
            if(visited[node] == 0)
            {
                dfs(node,parent,visited,adj);
            }
        }
    }
    public int getKthAncestor(int node, int k) {
        for(int i=0; i<=height; i++)
        {
            // System.out.println((k&(1<<i)) + " for "+node + " "+i + " "+ k);
            if((k&(1<<i)) > 0)
            {
                // System.out.println("condition for "+node);
                node = sparse_matrix[node][i];
                if(node == -1)
                {
                    return -1;
                }
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */