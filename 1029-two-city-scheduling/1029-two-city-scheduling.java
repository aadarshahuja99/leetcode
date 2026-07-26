class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // send all 2n to A. Then we will need to select n people for which we can reverse the decision.
        // these n people must have the smallest values of - cost[i][0] + cost[i][B], sine we will be replacing the idea of sending them to A with the idea of sending them to B
        int ans = 0;
        int n = costs.length;
        int[] differences = new int[n];
        int idx = 0;
        for(int[] cost : costs)
        {
            differences[idx] = cost[1] - cost[0];
            idx++;
            ans += cost[0];
        }
        Arrays.sort(differences);
        for(int i=0; i<n/2; i++)
        {
            ans += differences[i];
        }
        return ans;
    }
}