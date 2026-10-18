class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // 2 times Topo sort is to be applied (An extended version of the Kartik Arora mock Adobe interview)
        int[][] grid = new int[k][k];
        var rowOrder = evaluateOrder(k, rowConditions);
        if(rowOrder.size() < k)
        {
            return new int[0][];
        }

        var colOrder = evaluateOrder(k, colConditions);
        if(colOrder.size() < k)
        {
            return new int[0][];
        }

        for(int i=1; i<=k; i++)
        {
            int r = rowOrder.get(i);
            int c = colOrder.get(i);
            grid[r][c] = i;
        }
        return grid;
    }

    private HashMap<Integer,Integer> evaluateOrder(int k, int[][] conditions)
    {
        Queue<Integer> bfs = new LinkedList<>();
        ArrayList<Integer>[] rowAdj = new ArrayList[k];
        for(int i=0; i<k; i++)
        {
            rowAdj[i] = new ArrayList<>();
        }
        int[] indegree = new int[k];
        for(int[] condition : conditions)
        {
            rowAdj[condition[0]-1].add(condition[1] - 1);
            indegree[condition[1]-1]++;
        }
        for(int i=0; i<k; i++)
        {
            if(indegree[i] == 0)
            {
                bfs.add(i);
            }
        }
        int counter = 0;
        HashMap<Integer,Integer> order = new HashMap<>();
        while(bfs.size() > 0)
        {
            int s = bfs.size();
            for(int i=0; i<s; i++)
            {
                int top = bfs.poll();
                order.put(top+1, counter);
                counter++;
                for(int node : rowAdj[top])
                {
                    indegree[node]--;
                    if(indegree[node] == 0)
                    {
                        bfs.add(node);
                    }
                }
            }
        }
        return order;
    }
}