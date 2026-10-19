class Solution {
    public int numSimilarGroups(String[] strs) {
        int numStrings = strs.length;
        DS ds = new DS(numStrings);
        for(int i=0; i<numStrings; i++)
        {
            for(int j=0; j<numStrings; j++)
            {
                if(i == j)
                {
                    continue;
                }
                if(checkSimilarity(strs[i], strs[j]))
                {
                    ds.union(i,j);
                }
            }
        }
        return ds.findComponents();
    }
    private boolean checkSimilarity(String s, String t)
    {
        int n = s.length();
        int diffs = 0;
        for(int i=0; i<n; i++)
        {
            if(s.charAt(i) != t.charAt(i))
            {
                diffs++;
                if(diffs > 2)
                {
                    return false;
                }
            }
        }
        return true;
    }
    class DS 
    {
        int[] p;
        int[] s;
        int numStrings;
        DS(int n)
        {
            numStrings = n;
            p = new int[n];
            s = new int[n];
            Arrays.fill(s,1);
            for(int i=0; i<n; i++)
            {
                p[i] = i;
            }
        }
        int findParent(int u)
        {
            return p[u] = p[u] == u ? u : findParent(p[u]);
        }
        void union(int u, int v)
        {
            int uPar = findParent(u);
            int vPar = findParent(v);
            if(uPar == vPar) return;
            if(s[uPar] >= s[vPar])
            {
                s[uPar] += s[vPar];
                p[vPar] = uPar;
            }
            else
            {
                s[vPar] += s[uPar];
                p[uPar] = vPar;
            }
        }
        int findComponents()
        {
            int count = 0;
            for(int i=0; i<numStrings; i++)
            {
                if(findParent(i) == i)
                {
                    count++;
                }
            }
            return count;
        }
    }
}