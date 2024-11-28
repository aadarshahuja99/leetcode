class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // almost the same as minimum height trees (diameter can have atmost 2 nodes which will result in min height tree)
        int n = edges1.length+1;
        int m = edges2.length+1;
        if(n == 1 && m == 1)
        {
            return 1;
        }
        ArrayList<ArrayList<Integer>> adjList1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjList2 = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList1.add(new ArrayList<>());
        }
        int[] deg1 = new int[n];
        int[] deg2 = new int[m];
        for(int i=0; i<m; i++)
        {
            adjList2.add(new ArrayList<>());
        }
        for(int[] edge : edges1)
        {
            adjList1.get(edge[0]).add(edge[1]);
            adjList1.get(edge[1]).add(edge[0]);
            deg1[edge[0]]++;
            deg1[edge[1]]++;
        }
        for(int[] edge : edges2)
        {
            adjList2.get(edge[0]).add(edge[1]);
            adjList2.get(edge[1]).add(edge[0]);
            deg2[edge[0]]++;
            deg2[edge[1]]++;
        }
        int[] ans1 = getAnsForTree(adjList1, deg1);
        int[] ans2 = getAnsForTree(adjList2, deg2);
        // System.out.println(ans1[0]+" "+ans1[1]);
        // System.out.println(ans2[0]+" "+ans2[1]);
        return Math.max(ans1[0] + ans1[1], Math.max(ans2[0] + ans2[1], ans1[0] + ans2[0] + 1));
    }
    private int[] getAnsForTree(ArrayList<ArrayList<Integer>> adjList, int[] deg)
    {
        int n = adjList.size();
        if(n == 1)
        {
            return new int[] { 0, 0 };
        }
        int moves = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            if(deg[i] == 1)
            {
                queue.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(queue.size() > 0)
        {
            int s = queue.size();
            res = new ArrayList<>();
            for(int i=0; i<s; i++)
            {
                int top = queue.poll();
                res.add(top);
                // System.out.println("added "+top);
                for(int node : adjList.get(top))
                {
                    deg[node]--;
                    if(deg[node] == 1)
                    {
                        queue.add(node);
                    }
                }
            }
            // System.out.println();
            moves++;
        }
        // System.out.println();
        // System.out.println();
        int max = 0;
        int secondMax = 0;
        if(res.size() == 2)
        {
            max = moves;
            secondMax = moves-1;
        }
        else
        {
            max = moves-1;
            secondMax = moves-1;
        }
        return new int[] { max, secondMax };
    }
}