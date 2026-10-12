class Solution {
    public int numTrees(int n) {
        int[] numberOfTrees = new int[n+1];
        numberOfTrees[0] = 1;
        numberOfTrees[1] = 1;
        for(int i=2; i<=n; i++)
        {
            int current = 0;
            // both left and right subtrees can have 0 to i-1 nodes
            for(int leftSubTreeSize = 0; leftSubTreeSize < i; leftSubTreeSize++)
            {
                current += numberOfTrees[leftSubTreeSize]*numberOfTrees[i-leftSubTreeSize-1];
            }
            numberOfTrees[i] = current;
        }
        return numberOfTrees[n];
    }
}