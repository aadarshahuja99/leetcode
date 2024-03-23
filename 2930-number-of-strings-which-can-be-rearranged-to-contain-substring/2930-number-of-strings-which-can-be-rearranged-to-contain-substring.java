class Solution {
    int modulo = 1000000007;
    public int stringCount(int n) {
        int[][] dp = new int[n][16];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        return getAns(0,0,n,dp);
    }
    private int getAns(int current, int state, int n, int[][] dp)
    {
        if(current == n)
        {
            if(state == 15)
            {
                return 1;
            }
            return 0;
        }
        if(dp[current][state] != -1)
        {
            return dp[current][state];
        }
        int ans = 0;
        int[] positions = new int[] { 11,4,19 };
        for(int i=0; i<26; i++)
        {
            if(i==4)
            {
                if((state&(1<<1)) == 0)
                {
                    ans = (ans%modulo + getAns(current+1, state|(1<<1), n, dp)%modulo)%modulo;
                }
                else if((state&(1<<2)) == 0)
                {
                    ans = (ans%modulo + getAns(current+1, state|(1<<2), n, dp)%modulo)%modulo;
                }
                else
                {
                    ans = (ans%modulo + getAns(current+1, state, n, dp)%modulo)%modulo;
                }
            }
            else if(i==11)
            {
                if((state&(1<<0)) == 0)
                {
                    ans = (ans%modulo + getAns(current+1, state|(1<<0), n, dp)%modulo)%modulo;
                }
                else
                {
                    ans = (ans%modulo + getAns(current+1, state, n, dp)%modulo)%modulo;
                }
            }
            else if(i==19)
            {
                if((state&(1<<3)) == 0)
                {
                    ans = (ans%modulo + getAns(current+1, state|(1<<3), n, dp)%modulo)%modulo;
                }
                else
                {
                    ans = (ans%modulo + getAns(current+1, state, n, dp)%modulo)%modulo;
                }
            }
            else
            {
                ans = (ans%modulo + getAns(current+1, state, n, dp)%modulo)%modulo;
            }
        }
        return dp[current][state] = ans;
    }
}