class Solution {
    public boolean winnerSquareGame(int n) {
        if(n==1)
        {
            return true;
        }
        Boolean[] dp = new Boolean[n+1];
        return check(n, dp);
    }
    private boolean check(int current, Boolean[] dp)
    {
        if(dp[current] != null)
        {
            return dp[current];
        }
        int sqrt = (int)Math.sqrt(current);
        for(int i=1; i<=sqrt; i++)
        {
            if(!check(current-i*i, dp))
            {
                dp[current] = true;
                return true;
            }
        }
        dp[current] = false;
        return false;
    }
}