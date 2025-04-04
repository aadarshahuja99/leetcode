/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int maxDepth = 0;
    HashMap<Integer,ArrayList<Integer>> map;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        map = new HashMap<>();
        dfs(nestedList, 1);
        int ans = 0;
        for(int key : map.keySet())
        {
            for(int depth : map.get(key))
            {
                ans += (maxDepth - depth + 1)*key;
            }
        }
        return ans;
    }
    private void dfs(List<NestedInteger> level, int depth)
    {
        maxDepth = Math.max(depth, maxDepth);
        for(var element : level)
        {
            if(element.isInteger())
            {
                if(!map.containsKey(element.getInteger()))
                {
                    map.put(element.getInteger(), new ArrayList<>());
                }
                map.get(element.getInteger()).add(depth);
            }
            else
            {
                dfs(element.getList(), depth+1);
            }
        }
    }
}