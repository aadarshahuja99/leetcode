class Solution {
    public int[][] validArrangement(int[][] pairs) {
        // check if we have a eulerian circuit
        // if not, then find the two nodes with odd degree (euler path)
        HashMap<Integer,Integer> deg = new HashMap<>();
        HashMap<Integer,LinkedList<Integer>> adj = new HashMap<>();
        int start = -1;
        for(int[] p : pairs)
        {
            if(!adj.containsKey(p[0]))
            {
                adj.put(p[0], new LinkedList<>());
            }
            adj.get(p[0]).addLast(p[1]);
            deg.put(p[0], deg.getOrDefault(p[0], 0) + 1);
            deg.put(p[1], deg.getOrDefault(p[1], 0) - 1);
        }
        for(int key : deg.keySet())
        {
            int val = deg.get(key);
            if(val != 0)
            {
                if(val == 1)
                {
                    start = key;
                    break;
                }
            }
        }
        if(start == -1)
        {
            Iterator<Integer> it = deg.keySet().iterator();
            if(it.hasNext())
            {
                start = it.next();
            }
        }
        Stack<Integer> st = new Stack<>();
        dfs(start, st, adj);
        int[][] ans = new int[st.size()-1][2];
        int last = -1;
        int index = 0;
        while(st.size() > 0)
        {
            int top = st.pop();
            if(last != -1)
            {
                ans[index] = new int[] { last, top };
                index++;
            }
            last = top;
        }
        return ans;
    }
    private void dfs(int current, Stack<Integer> st, HashMap<Integer,LinkedList<Integer>> adj)
    {
        var list = adj.getOrDefault(current, new LinkedList<>());
        while(list.size() > 0)
        {
            int node = list.removeFirst();
            dfs(node, st, adj);
        }
        st.add(current);
    }
}