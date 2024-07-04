class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer,ArrayList<Integer>> tree = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            if(!tree.containsKey(manager[i]))
            {
                tree.put(manager[i], new ArrayList<>());
            }
            tree.get(manager[i]).add(i);
        }
        return dfs(headID, tree, informTime);
    }
    private int dfs(int current, HashMap<Integer,ArrayList<Integer>> tree, int[] informTime)
    {
        int max = 0;
        int sum = informTime[current];
        if(!tree.containsKey(current))
        {
            return 0;
        }
        for(int node : tree.get(current))
        {
            max = Math.max(max, dfs(node, tree, informTime));
        }
        return sum + max;
    }
}