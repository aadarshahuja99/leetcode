class Solution {
    public boolean checkContradictions(List<List<String>> equations, double[] vals) {
        HashMap<String,List<Element>> map = new HashMap<>();
        int idx = 0;
        for(List<String> eq : equations)
        {
            String u = eq.get(0);
            String v = eq.get(1);
            boolean flag = false;
            if(!map.containsKey(u))
            {
                flag = true;
                map.put(u, new ArrayList<>());
            }
            if(!map.containsKey(v))
            {
                flag = true;
                map.put(v, new ArrayList<>());
            }
            if(u.equals(v) && vals[idx] != 1.0)
            {
                return true;
            }
            double inv = 1.0/vals[idx];
            map.get(u).add(new Element(v, vals[idx]));
            map.get(v).add(new Element(u, inv));
            if(!flag)
            {
                if(!dfs(u, v, 1.0, vals[idx], new HashSet<String>(), map))
                {
                    return true;
                }
            }
            idx++;
        }
        return false;
    }
    private boolean dfs(String curr, String dest, double valSoFar, double target, HashSet<String> vis, HashMap<String,List<Element>> adj)
    {
        vis.add(curr);
        if(curr.equals(dest))
        {
            return valSoFar == target;
        }
        for(var node : adj.get(curr))
        {
            if(vis.contains(node.key))
            {
                continue;
            }
            if(!dfs(node.key, dest, valSoFar*node.val, target, vis, adj))
            {
                return false;
            }
        }
        return true;
    }
    class Element
    {
        String key;
        double val;
        public Element(String k, double v)
        {
            key = k;
            val = v;
        }
    }
}