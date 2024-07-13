class Solution {
    public int countHighestScoreNodes(int[] parents) {
        ArrayList<ArrayList<Integer>> children = new ArrayList<>();
        for(int i=0; i<parents.length; i++)
        {
            children.add(new ArrayList<>());
        }
        int idx = 0;
        for(int p : parents)
        {
            if(p == -1)
            {
                idx++;
                continue;
            }
            children.get(p).add(idx);
            idx++;
        }
        int[][] size = new int[parents.length][2];
        dfs(0, children, size);
        long[] ans = new long[parents.length];
        ans[0] = 1l*Math.max(size[0][0],1)*Math.max(size[0][1],1);
        getAns(ans, size, parents);
        long max = 0;
        int count = 0;
        idx = 0;
        for(long a : ans)
        {
            // System.out.println(a+" "+idx);
            if(a > max)
            {
                max = a;
                count = 1;
            }
            else if(a == max)
            {
                count++;
            }
            idx++;
        }
        return count;
    }
    private void getAns(long[] ans, int[][] size, int[] parent)
    {
        int total = 1 + size[0][0] + size[0][1];
        int n = parent.length;
        // System.out.println(n);
        for(int i=1; i<n; i++)
        {
            long pNodes = total - size[i][0] - size[i][1] - 1;
            long c1 = Math.max(size[i][0],1);
            long c2 = Math.max(size[i][1],1);
            // System.out.println("ans for "+i+" "+c1+" "+c2+" "+pNodes+ " " + total);
            ans[i] = c1*c2*pNodes;
        }
    }
    private int dfs(int current, ArrayList<ArrayList<Integer>> children, int[][] size)
    {
        if(children.get(current).size() == 0)
        {
            return 1;
        }
        int idx = 0;
        for(int node : children.get(current))
        {
            // System.out.println(node+" child for "+current);
            size[current][idx] = dfs(node, children, size);
            idx++;
        }
        // System.out.println(size[current][0]+" "+size[current][1]+" "+current);
        return size[current][0] + size[current][1] + 1;
    }
}