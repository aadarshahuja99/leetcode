class Solution {
    int MOD = 1000000007;
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        HashSet<Integer>[] sets = new HashSet[n];
        int idx = 0;
        for(var list : hats)
        {
            sets[idx] = new HashSet<>();
            for(int hat : list)
            {
                sets[idx].add(hat);
            }
            idx++;
        }
        int maxState = (1<<n);
        int[][] dp = new int[41][maxState];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        return getAns(1, 0, sets, dp);
    }
    private int getAns(int current, int state, HashSet<Integer>[] sets, int[][] dp)
    {
        // initial approach was iterating people and setting hats in state but it would have caused TC and SC exceeded issues as hats are 40 and iterating 2^40 states is not optimal. So it is better to use hats as the index and people as state. In each function call, we assign the 'current' hat to one person and move on to the next call. This ensures atmost-once selection of a hat 
        if(current == 41)
        {
            return state == (1<<(sets.length))-1 ? 1 : 0;
        }
        if(state == (1<<(sets.length))-1)
        {
            return 1;
        }
        if(dp[current][state] != -1)
        {
            return dp[current][state];
        }
        // ans count set to the case of not using the current hat initially
        int ans = getAns(current+1, state, sets, dp);
        for(int i=0; i<sets.length; i++)
        {
            if(sets[i].contains(current) && (state&(1<<i)) == 0)
            {
                ans = (ans + getAns(current+1, (state|(1<<i)), sets, dp))%MOD;
            }
        }
        return dp[current][state] = ans;
    }
}