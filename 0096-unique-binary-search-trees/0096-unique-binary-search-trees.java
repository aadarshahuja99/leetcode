class Solution {
    public int numTrees(int n) {
        int[] countOfTrees = new int[n+1];
        countOfTrees[0] = 1;
        for(int i=1; i<=n; i++)
        {
            int current = 0;
            for(int leftSubTreeSize = 0; leftSubTreeSize < i; leftSubTreeSize++)
            {
                current += countOfTrees[leftSubTreeSize]*countOfTrees[i-leftSubTreeSize-1];
            }
            countOfTrees[i] = current;
        }
        return countOfTrees[n];
    }
}