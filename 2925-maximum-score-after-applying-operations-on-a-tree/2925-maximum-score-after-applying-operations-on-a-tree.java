class Solution {
    long ans = 0;
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        long valuesSum = 0;
        for(int value : values)
        {
            valuesSum += value;
        }
        ans = valuesSum;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<values.length; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        HashMap<String,Long> cache = new HashMap<>();
        return getAns(0, -1, 1, adjList, values, cache);
    }
    private long getAns(int current, int parent, int canKeep, ArrayList<ArrayList<Integer>> adjList, int[] values, HashMap<String,Long> cache)
    {
        if(adjList.get(current).size() == 1 && current != 0)
        {
            return canKeep == 1 ? 0 : values[current];
        }
        String key = String.format("%1$s_%2$s", current, canKeep);
        if(cache.containsKey(key))
        {
            return cache.get(key);
        }
        long keep = 0;
        long collect = values[current];
        long collectChild = values[current];
        for(int node : adjList.get(current))
        {
            if(node != parent)
            {
                if(canKeep == 1)
                {
                    keep += getAns(node, current, 0, adjList, values, cache);
                    collectChild += getAns(node, current, 1, adjList, values, cache);
                }
                else
                {
                    collect += getAns(node, current, 0, adjList, values, cache);
                }
            }
        }
        if(canKeep == 1)
        {
            long currentMax = Math.max(keep, collectChild);
            cache.put(key, currentMax);
            return currentMax;
        }
        cache.put(key, collect);
        return collect;
    }
}