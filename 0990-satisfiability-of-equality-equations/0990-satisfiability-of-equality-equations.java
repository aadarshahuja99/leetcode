class Solution {
    public boolean equationsPossible(String[] equations) {
        DisjointSet ds = new DisjointSet();
        for(String equation : equations)
        {
            if(equation.charAt(1) == '=')
            {
                ds.union((int)equation.charAt(0)-97,(int)equation.charAt(3)-97);
            }
        }
        for(String equation : equations)
        {
            // if the 2 variables provided in the current equation have been connected previously, and are now being disconnected, then it will become impossible to satisfy all equations
            if(equation.charAt(1) == '!' && ds.findParent((int)equation.charAt(0)-97) == ds.findParent((int)equation.charAt(3)-97))
            {
                return false;
            }
        }
        return true;
    }
    class DisjointSet
    {
        private int[] size;
        private int[] parent;
        public DisjointSet()
        {
            size = new int[26];
            parent = new int[26];
            for(int i=0; i<26; i++)
            {
                parent[i] = i;
            }
            Arrays.fill(size,1);
        }
        public void union(int u, int v)
        {
            int parU = findParent(u);
            int parV = findParent(v);
            if(parU == parV)
            {
                return;
            }
            if(size[parV] > size[parU])
            {
                parent[parV] = parU;
                size[parU] += size[parV];
            }
            else
            {
                parent[parU] = parV;
                size[parV] += size[parU];
            }
        }
        public int findParent(int node)
        {
            int temp = node;
            while(temp != parent[temp])
            {
                temp = parent[temp];
            }
            parent[node] = temp;
            return temp;
        }
    }
}