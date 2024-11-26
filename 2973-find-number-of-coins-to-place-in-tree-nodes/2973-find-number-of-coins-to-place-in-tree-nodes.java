class Solution {
    long[] ans;
    public long[] placedCoins(int[][] edges, int[] cost) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<cost.length; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int n = cost.length;
        ans = new long[n];
        boolean[] vis = new boolean[n];
        dfs(0, vis, adj, cost);
        return ans;
    }
    private Element dfs(int current, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int[] cost)
    {
        Element e = new Element();
        vis[current] = true;
        PriorityQueue<Integer> n = new PriorityQueue<Integer>((a,b) -> {
            return b-a;
        });
        PriorityQueue<Integer> p = new PriorityQueue<Integer>((a,b) -> {
            return a-b;
        });
        for(int node : adj.get(current))
        {
            if(vis[node])
            {
                continue;
            }
            var op = dfs(node, vis, adj, cost);
            for(int v : op.pos)
            {
                p.add(v);
                if(p.size() > 3)
                {
                    p.poll();
                }
            }
            for(int v : op.neg)
            {
                n.add(v);
                if(n.size() > 2)
                {
                    n.poll();
                }
            }
            e.subtreeCount += op.subtreeCount;
        }
        if(cost[current] < 0)
        {
            n.add(cost[current]);
            if(n.size() > 2)
            {
                n.poll();
            }
        }
        else
        {
            p.add(cost[current]);
            if(p.size() > 3)
            {
                p.poll();
            }
        }
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        while(p.size() > 0)
        {
            pos.add(p.poll());
        }
        while(n.size() > 0)
        {
            neg.add(n.poll());
        }
        Collections.reverse(pos);
        Collections.reverse(neg);
        // System.out.println("subtreecount for "+current+" "+e.subtreeCount);
        if(e.subtreeCount < 3)
        {
            ans[current] = 1l;
        }
        else
        {
            long currentNeg = 1l;
            for(int i=0; i<Math.min(2, neg.size()); i++)
            {
                currentNeg = currentNeg*neg.get(i);
            }
            long currentPos = 1l;
            long maxPos = 0l;
            for(int i=0; i<Math.min(3, pos.size()); i++)
            {
                if(i == 0)
                {
                    maxPos = 1l*pos.get(i);
                }
                currentPos = currentPos*pos.get(i);
            }
            if(currentNeg < 0)
            {
                if(pos.size() < 3)
                {
                    // 1 neg and 2 positives
                    ans[current] = 0l;
                }
                else
                {
                    // 3 positives
                    ans[current] = currentPos;
                }
            }
            else if(neg.size() >= 2)
            {
                if(pos.size() == 0)
                {
                    // all negs in the tree
                    ans[current] = 0l;
                }
                else if(pos.size() < 3)
                {
                    // atleast 2 negs and some positives
                    ans[current] = maxPos*currentNeg;
                }
                else
                {
                    // atleast 2 pos and 2 neg
                    ans[current] = Math.max(currentPos, maxPos*currentNeg);
                }
            }
            else
            {
                ans[current] = currentPos;
            }
        }
        // System.out.println("for "+current+" pos: "+pos);
        // System.out.println("for "+current+" neg: "+neg);
        e.pos = pos;
        e.neg = neg;
        return e;
    }
    class Element
    {
        public List<Integer> pos = new ArrayList<>();
        public List<Integer> neg = new ArrayList<>();
        public int subtreeCount = 1;
    }
}