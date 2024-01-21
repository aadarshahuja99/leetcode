class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DisjointSet ds = new DisjointSet();
        for(int i=0; i<s1.length(); i++)
        {
            if(s1.charAt(i) != s2.charAt(i))
            {
                // System.out.println((((int)s1.charAt(i))-97) + " " + (((int)s2.charAt(i))-97));
                ds.union(((int)s1.charAt(i))-97, ((int)s2.charAt(i))-97);
            }
        }
        String ans = "";
        for(int i=0; i<baseStr.length(); i++)
        {
            ans += String.valueOf((char)(ds.findParent(((int)baseStr.charAt(i)-97))+97));
        }
        return ans;
    }
    class DisjointSet
    {
        private int[] parent;
        // private int[] size;
        public DisjointSet()
        {
            parent = new int[26];
            // size = new int[26];
            for(int i=0; i<26; i++)
            {
                parent[i] = i;
                // size[i] = 1;
            }
        }
        public int findParent(int u)
        {
            int temp = u;
            while(parent[temp] != temp)
            {
                temp = parent[temp];
            }
            parent[u] = temp;
            return temp;
        }
        public void union(int u, int v)
        {
            int parU = findParent(u);
            int parV = findParent(v);
            if(parU < parV)
            {
                parent[parV] = parU;
            }
            else if(parU > parV)
            {
                parent[parU] = parV;
            }
        }
    }
}