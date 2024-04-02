class Solution {
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int numberOfNodes = edges.length + 1;
        for(int i=0; i<numberOfNodes; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[][] cache = new int[numberOfNodes][15];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return collectMaxPointsHelper(0, 0, -1, adjList, k, coins, cache);
    }
    private int collectMaxPointsHelper(int currentNode, int halves, int parent, ArrayList<ArrayList<Integer>> adjList, int k, int[] coins, int[][] cache)
    {
        if(halves >= 14)
        {
            return 0;
        }
        if(cache[currentNode][halves] != -1)
        {
            return cache[currentNode][halves];
        }
        int currentCoins = coins[currentNode]>>halves;
        int abs = currentCoins - k;
        int half = currentCoins>>1;
        for(int child : adjList.get(currentNode))
        {
            if(child != parent)
            {
                half += collectMaxPointsHelper(child, halves+1, currentNode, adjList, k, coins, cache);
                abs += collectMaxPointsHelper(child, halves, currentNode, adjList, k, coins, cache);
            }
        }
        int currentMax = Math.max(abs, half);
        cache[currentNode][halves] = currentMax;
        return currentMax;
    }
}