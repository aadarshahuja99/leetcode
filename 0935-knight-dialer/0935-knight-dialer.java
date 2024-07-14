class Solution {
    int mod = 1_000_000_007;
    public int knightDialer(int n) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<10; i++)
        {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(4);
        adjList.get(0).add(6);
        adjList.get(1).add(6);
        adjList.get(1).add(8);
        adjList.get(2).add(7);
        adjList.get(2).add(9);
        adjList.get(3).add(4);
        adjList.get(3).add(8);
        adjList.get(4).add(3);
        adjList.get(4).add(9);
        adjList.get(4).add(0);
        adjList.get(6).add(1);
        adjList.get(6).add(7);
        adjList.get(6).add(0);
        adjList.get(7).add(2);
        adjList.get(7).add(6);
        adjList.get(8).add(1);
        adjList.get(8).add(3);
        adjList.get(9).add(4);
        adjList.get(9).add(2);
        int a = 0;
        // for(var l : adjList)
        // {
        //     System.out.println(l);
        // }
        int[][] cache = new int[10][n+1];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        for(int i=0; i<10; i++)
        {
            a = (a%mod + getAns(i, 1, adjList, n, cache)%mod)%mod;
        }
        return a;
    }
    private int getAns(int current, int count, ArrayList<ArrayList<Integer>> adjList, int n, int[][] cache)
    {
        if(count == n)
        {
            return 1;
        }
        if(cache[current][count] != -1)
        {
            return cache[current][count];
        }
        // System.out.println(current);
        int ans = 0;
        for(int node : adjList.get(current))
        {
            // System.out.println("calling for "+node+" from "+current);
            ans = (ans%mod + getAns(node, count+1, adjList, n, cache)%mod)%mod;
        }
        return cache[current][count] = ans;
    }
}