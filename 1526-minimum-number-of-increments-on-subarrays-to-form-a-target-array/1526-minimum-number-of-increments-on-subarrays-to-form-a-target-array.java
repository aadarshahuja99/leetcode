class Solution {
    public int minNumberOperations(int[] target) {
        // the minimum value of target[i] will be 1, that is always positive diff will be there for each i
        // take the first target[0] as the diff being propogated
        // if we encounter a greater value then we add its value - prev value to the current answer as it will need extra ops. example: [1,5,10,2] 5 will use 1's operation (1 op it needed) so it only needs 4 extra ops. Similarly, 10 will use 5's 5 operations and only need additional 5 ops for itself. 2 will not need any additional ops as it can share its operations with the previous guy (10)
        // else if current number (target[i]) is lesser than previous, then it will not need dedicated additional operations. example: [4,3,2,1] ans = 4
        int ans = target[0];
        for(int i=1; i<target.length; i++)
        {
            ans += Math.max(0, target[i] - target[i-1]);
        }
        return ans;
    }
}