class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
        int numNodes = edges.length, edgeRemoved = -1, edgeMakesCycle = -1;
        int[] parent = new int[numNodes + 1];      
        
        for (int i = 0; i < numNodes; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (parent[v] != 0) {
                
                /* Assume we removed the second edge. */
                edgeRemoved = i; 
                break;
            }
            else
                parent[v] = u;          
        }
        
        UnionFind uf = new UnionFind(numNodes);
        for (int i = 0; i < numNodes; i++) {
            if (i == edgeRemoved)
                continue;
            int u = edges[i][0];
            int v = edges[i][1];
            if (!uf.union(u, v)) {
                edgeMakesCycle = i;
                break;
            }
        } 
        
        /* Handle with the cyclic problem only. */
        if (edgeRemoved == -1) {
            return edges[edgeMakesCycle];
        }
        
        /* Handle with the cyclic problem when we remove the wrong edge. */
        if (edgeMakesCycle != -1) { 
            int v = edges[edgeRemoved][1];
            int u = parent[v];
            return new int[]{u, v};
        } 
        
        /* CHandle with the cyclic problem when we remove the right edge. */
        return edges[edgeRemoved];
    }
    
    static class UnionFind {
        private int[] parent; 
        private int[] rank;
        
        public UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        private int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }
        
        private boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX == rootY)
                return false;
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootY] += rank[rootX];
            } else {
                parent[rootY] = rootX;
                rank[rootX] += rank[rootY];
            }
            return true;
        }
    }
}